package com.test.admin.controller;

import com.test.admin.bean.City;
import com.test.admin.bean.User;
import com.test.admin.sevlet.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    CityService cityService;
    @ResponseBody
    @GetMapping("/getcitybyid")
    public City getCity(@RequestParam("id") long id){


        return cityService.getById(id);
    }


    @ResponseBody
    @GetMapping("/city")
    public City saveCity(City city){

        cityService.savecity(city);
        return city;
    }

    @Autowired
    JdbcTemplate jdbcTemplate;
    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDb(){

        Long aLong = jdbcTemplate.queryForObject("select count(*) from employees",long.class);
        return aLong.toString();
    }
    
    
    // 来登录页，发请求返回登录页
    @GetMapping(value={"/","/login"})
    public String  loginPage(){

        return "login";
    }

    @PostMapping("/login")
    public String main(User user , HttpSession session, Model model){

        if (!StringUtils.isEmpty(user.getUserName())&& "123456".equals(user.getPassword())){

            session.setAttribute("loginUser",user);
            return "redirect:/main.html";

        }
        else {

            model.addAttribute("msg","账号密码错误");
            return "/login";

        }//防治直接访问/main.html能直接进入控制页面
        //登录成功
//        return "redirect:/main.html";//重定向到main.html,即将请求变成main.html 因此刷新的时候不是/login请求

    }           //进入主页面

    /*
    在主页面刷新的话会直接再次提交post的表单（账号密码），这就会导致不断的发送登录请求
    所以下一个方法是解决不断发送表单进入主页面的方式
     */

    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model){

        //是否登录。 一般用拦截器或者过滤器
//        Object loginUser = session.getAttribute("loginUser");
//        if (loginUser !=null){
//            return "main";
//        }
//        else {
//            model.addAttribute("msg","账号密码错误");
//            return "/login";
//        }
        /*
            有拦截器就可以不用写上面那个判断了
         */
    return "main";

    }
}
