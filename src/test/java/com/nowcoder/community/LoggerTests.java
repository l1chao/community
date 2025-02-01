package com.nowcoder.community;

import com.nowcoder.community.CommunityApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
//@ContextConfiguration(classes = CommunityApplication.class) //只要配置类有@SpringBootApplication注解就不用这里声明配置类。
public class LoggerTests {

    //通过Logger的工厂方法获取Logger
    private static final Logger logger = LoggerFactory.getLogger(LoggerTests.class);//传入的参数是为了区分多个Logger。

    @Test
    public void testLogger() {
        System.out.println(logger.getName());

        logger.debug("debug log");
        logger.info("info log");
        logger.warn("warn log");
        logger.error("error log");
    }

}