package com.newcoder.community.Config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

/**
 * @Auther: yzz
 * @Date: 2025-01-21
 * @Description:
 */

@Configuration
public class AlphaConfig {

    @Bean //Bean的名字是"simpleDateFormat"，该注解表示会将该函数的返回对象装配进Bean。
    public SimpleDateFormat simpleDateFormat(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
}
