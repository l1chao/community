package com.newcoder.community.controller;

import com.newcoder.community.service.AlphaService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.util.*;

/**
 * @Auther: yzz
 * @Date: 2025-01-20
 * @Description:
 */

@Controller
@RequestMapping("/alpha")
public class AlphaController {

    @Autowired
    private AlphaService alphaService;

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        int t = 1;

        return "Hello, SpringBoot.";

    }

    @RequestMapping("/data")
    @ResponseBody
    public String find(){
        return alphaService.find();
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response){

        //获取请求：请求方法、请求路径、请求头键值对
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> e = request.getHeaderNames(); //作用类似于iterator，但是比iterator更老，因为spring很老了，所以沿用之。
        while(e.hasMoreElements()){
            String name = e.nextElement();
            String value = request.getHeader(name);
            System.out.println("name:"+name+", value:"+value);
        }

        //获取请求：特定名字的参数
        System.out.println(request.getParameter("name")); //即URL的"?"后面的参数

        //设置返回：返回响应数据
        response.setContentType("text/html;charset=utf-8"); //response对象封装了输出流

        //设置返回：底层写入数据方式
        try (
                PrintWriter writer = response.getWriter()//jdk7新特性：小括号里面的配置用过会自动关闭。这就可不用手动finally了。
        ) {
            writer.write("<h1>牛客网<h1>"); //这实际上是底层做的事情，框架将会把这些底层操作封装好
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // /student?current=1&limit=20
    @RequestMapping(value = "/students",method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(
            @RequestParam(name = "current", required = false, defaultValue = "1") int current,
            @RequestParam(name = "limit", required = false, defaultValue = "20") int limit
    ){

        return "some students";
    }

    // /student/123
    @RequestMapping(path = "student/{id}")
    @ResponseBody
    public String getStudent(@PathVariable(name = "id")int id){
        System.out.println(id);
        return "a student";
    }

    // /student
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    @ResponseBody //这个默认响应的是非html的
    public String saveStudent(String name, int agg){
        System.out.println(name);
        System.out.println(agg);

        return "success!";
    }

    @RequestMapping(value = "/teacher",method = RequestMethod.POST)
    public ModelAndView getTeacher(String name, int age){
        ModelAndView mav = new ModelAndView();
        mav.addObject("name",name);
        mav.addObject("age",age);
        mav.setViewName("/demo/view");
        return mav;
    }

    @RequestMapping(value = "/school",method = RequestMethod.GET)
    public String getSchool(Model model){ //这个model也是FrontController所管理的
        model.addAttribute("name","北京大学");
        model.addAttribute("age","80");
        return "/demo/view";
    }

    //响应JSON格式数据（异步请求）
    //java对象 - JSON字符串 - JS对象
    @RequestMapping(value = "/emp",method = RequestMethod.GET)
    @ResponseBody //加上之后，浏览器知道返回字符串；否则认为是html文件
    public Map<String, Object> getEmp(){
        Map<String,Object> emp = new HashMap<>();
        emp.put("name","张三");
        emp.put("age",23);
        emp.put("sal`ary",8000.00);
        return emp;
    }

    //响应JSON：返回多个员工
    @RequestMapping(value = "/emps",method = RequestMethod.GET)
    @ResponseBody //加上之后，浏览器知道返回字符串；否则认为是html文件
    public List<Map<String, Object>> getEmps(){
        List list = new ArrayList<Map<String,Object>>();

        Map<String,Object> emp1 = new HashMap<>();
        emp1.put("name","张三");
        emp1.put("age",23);
        emp1.put("salary",8000.00);
        list.add(emp1);

        Map<String,Object> emp2 = new HashMap<>();
        emp2.put("name","飞机");
        emp2.put("age",20);
        emp2.put("salary",9000.00);
        list.add(emp2);

        return list;
    }
}
