package com.zr.news.service;

import com.zr.news.po.News;
import com.zr.news.vo.NewQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface NewService {

    //新闻管理页面，组合条件查询新闻列表
    Page<News> listNew(Pageable pageable, NewQuery newQuery);

    News saveNew(News news);

    News getNew(Long id);

    News updateNew(Long id,News news);

    void deleteNew(Long id);

    //主页显示新闻列表
    Page<News> listNew(Pageable pageable);

    //从竹业推荐最新新闻列表
    List<News> listRecommendNewTop(Integer size);

    //全局搜索
    Page<News> listNew(String query,Pageable pageable);

    News getAndConvert(Long id);

}
