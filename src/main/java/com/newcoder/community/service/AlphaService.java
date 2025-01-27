package com.newcoder.community.service;

import com.newcoder.community.dao.AlphaDao;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @Auther: yzz
 * @Date: 2025-01-21
 * @Description:
 */

@Service
//@Scope("prototype") //默认参数是"singleton"。prototype将会停止使用单例模式，每次getBean都会重新生成新的实例bean。后者的做法在实际开发中很少做。
public class AlphaService {

    @Autowired
    private AlphaDao alphaDao;

    public AlphaService(){
        System.out.println("实例化AlphaService");
    }

    @PostConstruct
    public void init(){
        System.out.println("初始化AlphaService");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("销毁AlphaService");
    }

    public String find(){
        return alphaDao.select();
    }
}
