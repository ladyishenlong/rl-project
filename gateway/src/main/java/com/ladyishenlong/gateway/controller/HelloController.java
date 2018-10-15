package com.ladyishenlong.gateway.controller;

import com.ladyishenlong.gateway.bean.ResponseMessage;
import com.ladyishenlong.gateway.api.IsoyuApi;
import com.ladyishenlong.gateway.test.TestBean;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("hello")
public class HelloController {

    @Autowired
    public IsoyuApi isoyuApi;

    @GetMapping("/hello")
    public ResponseMessage hello(){
        return ResponseMessage.suceess("hello");
    }

    @GetMapping("/hello2")
    public ResponseMessage hello2(){
        return ResponseMessage.suceess("hello2");
    }


    @GetMapping("/helloIsoyu")
    public String hellIsoyu(){
        return isoyuApi.helloIsoyu();
    }


}
