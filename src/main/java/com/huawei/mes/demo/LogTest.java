package com.huawei.mes.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 * ClassName LogTest
 * Description
 * Create by tiandongbo 00350982
 * Date 2021/3/31 13:23
 */
public class LogTest {
    @Test
    public void testCase01(){
        Log log = LogFactory.getLog(LogTest.class);
        //PropertyConfigurator.configure(".\\src\\log4j.properties");
        log.info("start...");
        log.warn("end.");
        log.error("error");
        log.debug("debug");
    }
}
