package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: yzz
 * @Date: 2025-01-22
 * @Description:
 */

@Mapper
public interface DiscussPostMapper {
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    //@Param用来给参数取别名
    //若只有一个参数，且需要在模板语言标签里面的<if>中使用，则必须要用@Param加别名
    int selectDiscussPostRows(@Param("userId") int userId);
}
