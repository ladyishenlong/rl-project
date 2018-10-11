package com.ladyishelong.isoyuapi.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class BaseController {

    @Autowired
    protected RestTemplate restTemplate;

    protected Gson gson;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        restTemplate=builder.build();
        return restTemplate;
    }


}
