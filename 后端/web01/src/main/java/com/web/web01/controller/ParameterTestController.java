package com.web.web01.controller;


import org.apache.tomcat.util.http.parser.Cookie;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTestController {

    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id, // 换取id信息
                                     @PathVariable("username") String name, //换取username信息
                                     @PathVariable  Map<String,String> pv,// 换取全部信息并放到map中
                                     @RequestHeader("User-Agent") String userAgent,// 换取请求头,
                                     @RequestHeader Map<String,String> header,// 换取全部请求头
                                     @RequestParam("age") Integer age, //换取年龄，请求参数
                               @RequestParam("inters") List<String> inters, // 换取兴趣，以列表的形式换取，请求参数
                                    @CookieValue("_ga")Cookie cookie
                                     ){

        Map<String,Object> map = new HashMap<>();

        map.put("id",id);
        map.put("name",name);
        map.put("pv",pv);
        map.put("userAgent",userAgent);
        map.put("header",header);
        System.out.println(cookie.toString());
        return map;
    }
}
