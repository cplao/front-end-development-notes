package com.web.web01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/img.png")
    public String hello(){
        return "aaa"; // 在有img.png的静态资源和img.png的请求中会首先搞请求
    }
}
