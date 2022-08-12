package com.dahuatech.test.jmeter.samplers.gitpush;

import org.apache.jmeter.gui.util.HorizontalPanel;
import org.apache.jmeter.gui.util.VerticalPanel;
import org.apache.jmeter.samplers.gui.AbstractSamplerGui;
import org.apache.jmeter.testelement.TestElement;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;

public class GitPushSamplerUI extends AbstractSamplerGui {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger("GitPushSampler");

    private JTextField server;
    private JTextField port;
    private JTextField userName;
    private JTextField userPwd;
    private JTextField cookie;
    private JTextField filesNum;
    private JTextArea gitPushGroups;

    public GitPushSamplerUI(){
        super();
        init();
    }

    private void init(){
        createPanel();
    }
    private void createPanel(){
        JPanel settingPanel = new VerticalPanel(8,0);
        settingPanel.add(getServerPanel());
        settingPanel.add(getPortPanel());
        settingPanel.add(getUserNamePanel());
        settingPanel.add(getUserPwdPanel());
        settingPanel.add(getCookiePanel());
        settingPanel.add(getFilesNumPanel());
        settingPanel.add(getGitPushGroupsPanel());

        JPanel dataPanel = new JPanel(new BorderLayout(8,0));
        dataPanel.add(settingPanel,BorderLayout.NORTH);
        setLayout(new BorderLayout(0,8));
        setBorder(makeBorder());
        add(makeTitlePanel(),BorderLayout.NORTH);
        add(dataPanel,BorderLayout.CENTER);
    }

    private JPanel getServerPanel(){
        server = new JTextField(10);
        JLabel label = new JLabel("host server: ");
        label.setLabelFor(server);

        JPanel panel = new HorizontalPanel();
        panel.add(label, BorderLayout.WEST);
        panel.add(server,BorderLayout.CENTER);
        return panel;
    }

    private JPanel getPortPanel(){
        port = new JTextField(10);
        JLabel label = new JLabel("server port: ");
        label.setLabelFor(port);

        JPanel panel = new HorizontalPanel();
        panel.add(label,BorderLayout.WEST);
        panel.add(port,BorderLayout.CENTER);
        return panel;
    }

    private JPanel getUserNamePanel(){
        userName = new JTextField(20);
        JLabel label = new JLabel("userName: ");
        label.setLabelFor(userName);

        JPanel panel = new HorizontalPanel();
        panel.add(label,BorderLayout.WEST);
        panel.add(userName,BorderLayout.CENTER);
        return panel;
    }

    private JPanel getUserPwdPanel(){
        userPwd = new JTextField(20);
        JLabel label = new JLabel("userPwd: ");
        label.setLabelFor(userPwd);

        JPanel panel = new HorizontalPanel();
        panel.add(label,BorderLayout.WEST);
        panel.add(userPwd,BorderLayout.CENTER);

        return panel;
    }

    private JPanel getCookiePanel(){
        cookie = new JTextField(20);
        JLabel label = new JLabel("cookie: ");
        label.setLabelFor(cookie);

        JPanel panel = new HorizontalPanel();
        panel.add(label,BorderLayout.WEST);
        panel.add(cookie,BorderLayout.CENTER);
        return panel;
    }

    private JPanel getFilesNumPanel(){
        filesNum = new JTextField(10);
        JLabel label = new JLabel("files Num: ");
        label.setLabelFor(filesNum);

        JPanel panel = new HorizontalPanel();
        panel.add(label,BorderLayout.WEST);
        panel.add(filesNum,BorderLayout.CENTER);
        return panel;
    }

    private JPanel getGitPushGroupsPanel(){
        gitPushGroups = new JTextArea(20,20);
        JLabel label = new JLabel("gitPushGroups");
        label.setLabelFor(gitPushGroups);

        JPanel panel = new HorizontalPanel();
        panel.add(label,BorderLayout.WEST);
        panel.add(gitPushGroups,BorderLayout.CENTER);
        return panel;
    }

    public String getLabelResource() {
        throw new IllegalStateException("This shouldn't be called");
    }

    public TestElement createTestElement() {
        GitPushSampler sampler = new GitPushSampler();
        modifyTestElement(sampler);
        return sampler;
    }

    public void modifyTestElement(TestElement testElement) {
        testElement.clear();
        configureTestElement(testElement);
        testElement.setProperty(GitPushSampler.SERVER,server.getText());
        testElement.setProperty(GitPushSampler.PORT,port.getText());
        testElement.setProperty(GitPushSampler.USERNAME,userName.getText());
        testElement.setProperty(GitPushSampler.USERPWD,userPwd.getText());
        testElement.setProperty(GitPushSampler.COOKIE,cookie.getText());
        testElement.setProperty(GitPushSampler.FILESNUM,filesNum.getText());
        testElement.setProperty(GitPushSampler.GITPUSHGROUPS,gitPushGroups.getText());
    }

    @Override
    public String getStaticLabel(){
        return "gitPushSampler";
    }

    @Override
    public void clearGui(){
        super.clearGui();
        server.setText("");
        port.setText("");
        userName.setText("");
        userPwd.setText("");
        cookie.setText("");
        filesNum.setText("");
        gitPushGroups.setText("");
    }

    @Override
    public void configure(TestElement testElement){
        super.configure(testElement);
        server.setText(testElement.getPropertyAsString(GitPushSampler.SERVER));
        port.setText(testElement.getPropertyAsString(GitPushSampler.PORT));
        userName.setText(testElement.getPropertyAsString(GitPushSampler.USERNAME));
        userPwd.setText(testElement.getPropertyAsString(GitPushSampler.USERPWD));
        cookie.setText(testElement.getPropertyAsString(GitPushSampler.COOKIE));
        filesNum.setText(testElement.getPropertyAsString(GitPushSampler.FILESNUM));
        gitPushGroups.setText(testElement.getPropertyAsString(GitPushSampler.GITPUSHGROUPS));
    }

}
