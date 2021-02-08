package com.example.demo1.controler;

import com.example.demo1.controler.result.Result;
import com.example.demo1.controler.result.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Controller
public class Usercontroler {

    @ResponseBody
    @RequestMapping("/name")
    public Result<User> hello(HttpServletRequest request) {
        String name = request.getParameter("username");
        User user = new User(name);
        return Result.Success(user);
    }
}





