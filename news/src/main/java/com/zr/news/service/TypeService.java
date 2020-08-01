package com.zr.news.service;

import com.zr.news.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TypeService {

    Page<Type> listType(Pageable pageable);

    Type savaType(Type type);

    Type getTypeByName(String name);

    void delete(Long id);

    Type getType(Long id);

    Type updateType(Long id,Type type);
}
