package com.newcoder.community.service;

import com.newcoder.community.dao.DiscussPostMapper;
import com.newcoder.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: yzz
 * @Date: 2025-01-23
 * @Description:
 */

@Service
public class DiscussPostService {
    @Autowired
    private DiscussPostMapper discussPostMapper;

    public List<DiscussPost> findDiscussPosts(int user_id, int offset, int limit){
        return discussPostMapper.selectDiscussPosts(user_id,offset,limit);
    }

    public int findDiscussPostRows(int user_id){
        return discussPostMapper.selectDiscussPostRows(user_id);
    }
}
