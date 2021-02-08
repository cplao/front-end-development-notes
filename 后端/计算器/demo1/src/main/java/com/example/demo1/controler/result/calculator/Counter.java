package com.example.demo1.controler.result.calculator;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Counter {
    public String deal_bracket(String exp) {
        String new_exp, res;
        String exp1 = exp;
        String regex = "\\([^()]+\\)";
        Pattern pattern = Pattern.compile(regex);
        while (true) {
            Matcher m = pattern.matcher(exp1);
            if (m.find()) {
                new_exp = m.group();
                res = calculate(new_exp);
                exp1 = exp1.replace(new_exp, res);
            } else {
                res = calculate(exp1);
                return res;
            }
        }
    }


    public String calculate(String exp) {
        String exp1 = exp.replace("(", "");
        String exp2 = exp1.replace(")", "");


        int answer = new Jsq().calculate(exp2);
        return String.valueOf(answer);
    }
}
