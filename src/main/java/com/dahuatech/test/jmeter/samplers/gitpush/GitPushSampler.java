package com.dahuatech.test.jmeter.samplers.gitpush;

import org.apache.jmeter.samplers.AbstractSampler;
import org.apache.jmeter.samplers.Entry;
import org.apache.jmeter.samplers.SampleResult;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class GitPushSampler extends AbstractSampler{
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger("GitPushSampler");

    public static final String SERVER = "server.text";
    public static final String PORT = "port.text";
    public static final String USERNAME = "userName.text";
    public static final String USERPWD = "userPwd.text";
    public static final String COOKIE = "cookie.text";
    public static final String FILESNUM = "filesNum.text";
    public static final String GITPUSHGROUPS = "gitPushGroups.text";

    public SampleResult sample(Entry entry) {
        trace("sample()");
        SampleResult result = new SampleResult();
        String server = getServer();
        String port = getPort();
        String userName = getUsername();
        String userPwd = getUserpwd();
        String cookie = getCookie();
        String filesNum = getFilesnum();
        String gitPushGroups = getGitpushgroups();

        boolean isOk = false;
        String response = null;
        result.setSampleLabel(getTitle());

        result.sampleStart();
        result.setSamplerData("sampler data");
        result.setDataType(SampleResult.TEXT);

        result.setResponseCodeOK();
        result.setResponseData("response data",null);
        return result;
    }

    public String getServer(){
        return getPropertyAsString(SERVER);
    }
    public String getPort(){
        return getPropertyAsString(PORT);
    }
    public String getUsername(){
        return getPropertyAsString(USERNAME);
    }
    public String getUserpwd(){
        return getPropertyAsString(USERPWD);
    }
    public String getCookie(){
        return getPropertyAsString(COOKIE);
    }
    public String getFilesnum(){
        return getPropertyAsString(FILESNUM);
    }
    public String getGitpushgroups(){
        return getPropertyAsString(GITPUSHGROUPS);
    }

    private String getTitle(){
        return this.getName();
    }

    public GitPushSampler(){
        setName("GitPushSampler");
    }
    private void trace(String s){
        String tl = getTitle();
        String tn = Thread.currentThread().getName();
        String th = this.toString();
    }
}
