package com.ladyishenlong.gateway.bean.news.list;

import com.ladyishenlong.gateway.bean.BaseBean;
import lombok.Data;

import java.util.List;

@Data
public class NewsListBean extends BaseBean {
    public List<NewsListData> data;

}
