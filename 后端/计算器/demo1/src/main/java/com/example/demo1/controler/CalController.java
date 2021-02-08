package com.example.demo1.controler;

import com.example.demo1.controler.result.Result;
import com.example.demo1.controler.result.User;
import com.example.demo1.controler.result.calculator.CalAnswer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Controller
public class CalController {

    @ResponseBody
    @RequestMapping("/formula")
    public Result<CalAnswer> hello(HttpServletRequest request) {
        String formula = request.getParameter("formula");
        CalAnswer calAnswer = new CalAnswer(formula);
        return Result.Success(calAnswer);
    }

}
