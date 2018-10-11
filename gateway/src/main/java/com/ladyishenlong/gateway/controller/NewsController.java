package com.ladyishenlong.gateway.controller;

import com.ladyishenlong.gateway.api.NewsApi;
import com.ladyishenlong.gateway.bean.news.detail.NewsDetailBean;
import com.ladyishenlong.gateway.bean.news.list.NewsListBean;
import com.ladyishenlong.gateway.bean.news.list.NewsListData;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/getNews")
@Api("新闻")
public class NewsController {


    @Autowired
    public NewsApi newsApi;

    @GetMapping("/getList")
    public NewsListBean newsList(@RequestParam("type")String type,
                                 @RequestParam("page")String page){
        return newsApi.getNewsList(type,page);
    }


    @GetMapping("/getDetail")
    public NewsDetailBean newsDetail(@RequestParam("postid") String postid){
        return newsApi.getNewsDetail(postid);
    }

}
