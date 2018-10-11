package com.ladyishelong.isoyuapi.controller;


import com.google.gson.Gson;
import com.ladyishelong.isoyuapi.Isoyu;
import com.ladyishelong.isoyuapi.bean.news.detail.NewsDetailBean;
import com.ladyishelong.isoyuapi.bean.news.list.NewsListBean;
import com.ladyishelong.isoyuapi.bean.news.list.NewsListData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/news")
public class NewsController extends BaseController {


    @GetMapping("/list")
    public NewsListBean newsList(@RequestParam("type") String type,
                                 @RequestParam("page") String page) {
        log.info("-----获取新闻列表-----");
        String newsList = restTemplate
                .getForObject(Isoyu.BASE_URL + Isoyu.NEWS_LIST +
                        "?type=" + type + "&page=" + page, String.class);
        gson = new Gson();
        NewsListBean newsListBean = gson.fromJson(newsList, NewsListBean.class);
        return newsListBean;
    }



    @GetMapping("/details")
    public NewsDetailBean newsDetails(@RequestParam("postid") String postid) {
        log.info("----获取新闻详情-----");

        String newsDetail = restTemplate
                .getForObject(Isoyu.BASE_URL + Isoyu.NEWS_DETAILS +
                        "?postid=CLJN5K2M000181KT", String.class);
        gson = new Gson();
        NewsDetailBean newsDetailBean =
                gson.fromJson(newsDetail, NewsDetailBean.class);
        return newsDetailBean;
    }


}
