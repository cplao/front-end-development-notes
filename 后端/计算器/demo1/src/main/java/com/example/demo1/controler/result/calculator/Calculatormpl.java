package com.example.demo1.controler.result.calculator;

interface Calculator {
    Integer add(Integer num1, Integer num2); //加

    Integer sub(Integer num1, Integer num2); //减

    Integer mul(Integer num1, Integer num2); //乘

    Integer div(Integer num1, Integer num2); //除
}


public class Calculatormpl implements Calculator {

    @Override
    public Integer add(Integer num1, Integer num2) {
        return num1 + num2;
    }

    @Override
    public Integer sub(Integer num1, Integer num2) {

        return num1 - num2;
    }

    @Override
    public Integer mul(Integer qs, Integer num) {

        return qs * num;
    }

    @Override
    public Integer div(Integer num1, Integer num2) {

        return num1 / num2;
    }


}
