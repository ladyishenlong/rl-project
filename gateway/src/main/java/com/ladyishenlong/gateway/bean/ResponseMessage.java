package com.ladyishenlong.gateway.bean;

public class ResponseMessage<T>  {

    public Integer code;
    public String message;
    public T data;


    public ResponseMessage( Integer code,String message, T data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }


    public static <T> ResponseMessage suceess(T data) {
        return new ResponseMessage(1, "成功", data);
    }
    public static <T> ResponseMessage suceess(String message,T data) {
        return new ResponseMessage(1, message, data);
    }


    public static <T> ResponseMessage failure () {
        return new ResponseMessage(1, "请求失败",null);
    }

    public static <T> ResponseMessage failure (String message) {
        return new ResponseMessage(1, message,null);
    }

}
