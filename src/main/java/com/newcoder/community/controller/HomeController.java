package com.newcoder.community.controller;

import com.newcoder.community.entity.DiscussPost;
import com.newcoder.community.entity.Page;
import com.newcoder.community.entity.User;
import com.newcoder.community.service.DiscussPostService;
import com.newcoder.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: yzz
 * @Date: 2025-01-23
 * @Description:
 */

@Controller //默认是community路由
public class HomeController {
    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    //实现首页初始化，
    //将post的list和对应的user绑在一起形成新的Map,再返回Map的list。
    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page){

        //方法调用前，SpringMVC会自动实例化Page和Model，并将Page注入到Model里面去。
        //所以不需要手动将Page注入Model。
        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");
        List< DiscussPost> list = discussPostService.findDiscussPosts(0,page.getOffset(), page.getLimit());

        List<Map<String, Object>> discussPosts = new ArrayList<>();
        if(list!=null){
            for(DiscussPost post : list){
                int id = post.getUserId();
                User user = userService.findUserById(id);
                Map<String, Object> map = new HashMap<>();
                map.put("user",user);
                map.put("post",post);
                discussPosts.add(map);
            }
        }
        model.addAttribute("discussPosts", discussPosts);
        return "/index"; //这个地方将Model和thymeleaf模板文件联系起来了。
    }
}