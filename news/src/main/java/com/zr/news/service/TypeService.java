package com.zr.news.service;

import com.zr.news.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TypeService {

    Page<Type> listType(Pageable pageable);

}
