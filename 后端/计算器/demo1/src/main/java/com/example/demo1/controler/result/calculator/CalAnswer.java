package com.example.demo1.controler.result.calculator;

import org.junit.Test;

public class CalAnswer {
    public String answer;

    public CalAnswer(String formula) {

        this.answer = new Counter().deal_bracket(formula);

    }
}
