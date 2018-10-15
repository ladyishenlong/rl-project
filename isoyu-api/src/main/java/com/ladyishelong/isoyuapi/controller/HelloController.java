package com.ladyishelong.isoyuapi.controller;

import com.google.gson.Gson;
import com.ladyishelong.isoyuapi.Isoyu;
import com.ladyishelong.isoyuapi.bean.news.detail.NewsDetailBean;
import com.ladyishelong.isoyuapi.bean.news.list.NewsListBean;
import com.ladyishelong.isoyuapi.bean.news.list.NewsListData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController extends BaseController {

    @GetMapping("/helloIsoyu")
    public String helloIsoyu() {

        return "hello Isoyu";
    }

}
