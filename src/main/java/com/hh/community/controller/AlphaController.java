package com.hh.community.controller;

import com.hh.community.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/alpha")//请求路径(这是简化版，默认get请求，其他请求也可以)
public class AlphaController {
    @Autowired
     private AlphaService alphaService;
    @RequestMapping("/1")
    @ResponseBody //这是表明返回的是字符型，不加就会默认返回的是html
    public String method(){
        return "hello springboot!";
    }
    @RequestMapping("/2")
    @ResponseBody
    public String method1(){
        return alphaService.find();
    }

    //GET请求有以下两种传参方式;get请求是向服务器获取数据
    // 路径:/students  当前页：current  每页多少数据：limit  格式：students?current=1&limit=10
    @RequestMapping(path = "/students",method = RequestMethod.GET)//强制方法为get方法
    @ResponseBody
    public String getStudents(@RequestParam(name = "current",required = false,defaultValue = "1") int current,
                              @RequestParam(name = "limit",required = false,defaultValue = "20") int limit){
        System.out.println(current);
        System.out.println(limit);
        return "somestudent";
    }
    // 路径:/student/123
    @RequestMapping(path = "/student/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id) {
        System.out.println(id);
        return "a student";
    }

    //Post请求，向服务器提交数据
    @RequestMapping(path = "/student",method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name,int age){
        System.out.println(name);
        System.out.println(age);
        return "success";
    }
    // 响应HTML数据 以下两种方式
    @RequestMapping(path = "/teacher",method = RequestMethod.GET)
    public ModelAndView getTeacher(){
        ModelAndView mav=new ModelAndView();
        mav.addObject("name","张三");
        mav.addObject("age",22);
        mav.setViewName("/demo/view");
        return mav;
    }
    @RequestMapping(path = "school",method = RequestMethod.GET)
    public String getSchool(Model model){
        model.addAttribute("name","北大");
        model.addAttribute("age",100);
        return "/demo/view";
    }
    //相应json数据（异步请求）
    // 响应JSON数据(异步请求)
    // Java对象 -> JSON字符串 -> JS对象（浏览器是js响应）
    @RequestMapping(path = "/emp",method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> getEmp(){
        List<Map<String,Object>> list=new ArrayList<>();
        Map<String,Object> emp=new HashMap<>();
        emp.put("name","黄浩");
        emp.put("age",22);
        emp.put("salary",10000);
        list.add(emp);

        emp=new HashMap<>();
        emp.put("name","黄");
        emp.put("age",21);
        emp.put("salary",10000);
        list.add(emp);
        return list;

    }
}
