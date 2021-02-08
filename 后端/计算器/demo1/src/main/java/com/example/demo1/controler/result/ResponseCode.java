package com.example.demo1.controler.result;

public class ResponseCode {
    public int code;
    public String msg;

    public ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResponseCode SERVER_SUCCESS = new ResponseCode(200, "SUCCESS");
    public static ResponseCode SERVER_ERROR = new ResponseCode(100, "ERROR");
}
