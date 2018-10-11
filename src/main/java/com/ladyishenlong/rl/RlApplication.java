package com.ladyishenlong.rl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class RlApplication {
    public static void main(String[] args) {
        SpringApplication.run(RlApplication.class, args);
    }
}
