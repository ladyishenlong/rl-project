package com.ladyishelong.isoyuapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 去请求 isoyu 的api
 */
@SpringBootApplication
@EnableEurekaClient
public class IsoyuApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(IsoyuApiApplication.class, args);
    }

}
