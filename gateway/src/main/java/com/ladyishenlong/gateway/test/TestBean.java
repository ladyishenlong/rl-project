package com.ladyishenlong.gateway.test;

import lombok.Data;

@Data
public class TestBean {
    public String message;
    public Integer code;
    public String result;

    public TestBean(String message, Integer code, String result) {
        this.message = message;
        this.code = code;
        this.result = result;
    }

}
