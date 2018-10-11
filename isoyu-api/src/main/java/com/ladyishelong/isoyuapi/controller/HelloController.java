package com.ladyishelong.isoyuapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/helloIsoyu")
    public String helloIsoyu() {
        return "hello Isoyu";
    }

}
