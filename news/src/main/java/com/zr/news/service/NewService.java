package com.zr.news.service;

import com.zr.news.po.News;
import com.zr.news.vo.NewQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface NewService {

    Page<News> listNew(Pageable pageable, NewQuery newQuery);

    News saveNew(News news);

    News getNew(Long id);

    News updateNew(Long id,News news);

}
