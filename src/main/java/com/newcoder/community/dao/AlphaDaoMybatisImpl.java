package com.newcoder.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * @Auther: yzz
 * @Date: 2025-01-21
 * @Description: 体会Primary注解替换实现类的便利性。
 */


//简单来说，当AlphaDao接口实现类有多个的时候，想要替换，只需要将新的实现类加上Primary注解即可。
@Repository
@Primary //当有多个符合AlphaDao的实现类的时候，该注解能够让容器优先选择。
public class AlphaDaoMybatisImpl implements AlphaDao{
    @Override
    public String select() {
        return "Mybatis";
    }
}
