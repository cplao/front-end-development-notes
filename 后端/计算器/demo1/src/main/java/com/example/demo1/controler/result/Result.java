package com.example.demo1.controler.result;

public class Result<T> {
    public int code;
    public String msg;
    public T date;

    public Result(ResponseCode RC, T date) {
        this.code = RC.code;
        this.msg = RC.msg;
        this.date = date;
    }


    public static <T> Result<T> Success(T data) {
        return new Result<T>(ResponseCode.SERVER_SUCCESS, data);
    }

    public static <T> Result<T> Error(T data) {
        return new Result<T>(ResponseCode.SERVER_ERROR, data);
    }

}
