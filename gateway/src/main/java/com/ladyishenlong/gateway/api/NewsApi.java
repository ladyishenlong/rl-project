package com.ladyishenlong.gateway.api;

import com.ladyishenlong.gateway.bean.news.detail.NewsDetailBean;
import com.ladyishenlong.gateway.bean.news.list.NewsListBean;
import com.ladyishenlong.gateway.bean.news.list.NewsListData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Repository
@FeignClient("isoyu-api")
@ApiIgnore
@RequestMapping("/news")
public interface NewsApi {

    @GetMapping("/list")
    NewsListBean getNewsList(@RequestParam("type")String type, @RequestParam("page")String page);


    @GetMapping("/details")
    NewsDetailBean getNewsDetail(@RequestParam("postid") String postid);

}
