package com.ladyishenlong.gateway.controller;

import com.ladyishenlong.gateway.api.IsoyuApi;
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
    public String hello(){
        return "hello";
    }



    @GetMapping("/helloIsoyu")
    public String hellIsoyu(){
        return isoyuApi.helloIsoyu();
    }



}
