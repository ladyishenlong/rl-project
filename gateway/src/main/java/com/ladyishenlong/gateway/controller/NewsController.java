package com.ladyishenlong.gateway.controller;

import com.ladyishenlong.gateway.api.NewsApi;
import com.ladyishenlong.gateway.bean.ResponseMessage;
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
    public ResponseMessage newsList(@RequestParam("type") String type,
                                    @RequestParam("page") String page) {

        NewsListBean newsList = newsApi.getNewsList(type, page);

        if (newsList.code == 1) {
            return ResponseMessage.suceess("获取新闻列表成功", newsList.data);
        } else {
            return ResponseMessage.failure("获取新闻列表失败");
        }

    }


    @GetMapping("/getDetail")
    public ResponseMessage newsDetail(@RequestParam("postid") String postid) {
        return ResponseMessage.suceess(newsApi.getNewsDetail(postid).data);
    }

}
