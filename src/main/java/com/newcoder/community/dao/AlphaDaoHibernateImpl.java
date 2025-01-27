package com.newcoder.community.dao;

import org.springframework.stereotype.Repository;

/**
 * @Auther: yzz
 * @Date: 2025-01-21
 * @Description:
 */

@Repository("alphaHibernate") //能够访问数据库的bean，加上后容器将会扫描并添加成功。
public class AlphaDaoHibernateImpl implements AlphaDao{
    @Override
    public String select() {
        return "Hibernate";
    }
}
