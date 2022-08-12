package com.dahuatech.test.jmeter.samplers.gitpush;

import org.apache.jmeter.samplers.gui.AbstractSamplerGui;
import org.apache.jmeter.testelement.TestElement;

public class MySamplerGUI extends AbstractSamplerGui{
    public String getLabelResource() {
        return null;
    }

    public TestElement createTestElement() {
        MySampler sampler = new MySampler();
        return sampler;
    }

    public void modifyTestElement(TestElement testElement) {

    }
}
