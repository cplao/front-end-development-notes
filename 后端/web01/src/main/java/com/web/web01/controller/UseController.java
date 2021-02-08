package com.web.web01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class UseController {

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getUser(){
        return "User Get";
    }
    @GetMapping("/user") // = @RequestMapping(value = "/User", method = RequestMethod.POST)
    public String postUser(){
        return "User Post";
    }

    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public String deleteUser(){
        return "User Delete";
    }

    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String putUser(){
        return "User Put";
    }

//    用postman等请求是不用开启Rest功能的
//    有一次试过这个conctroller无法运行

}
