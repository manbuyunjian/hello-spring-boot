package com.mall.hello.spring.boot.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String getWechatOpenid(){
        return "index，hello";
    }
}
