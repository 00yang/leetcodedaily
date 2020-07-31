package com.zr.news.service.impl;

import com.zr.news.dao.TypeRepository;
import com.zr.news.po.Type;
import com.zr.news.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Override
    public Page<Type> listType(Pageable pageable){
        return typeRepository.findAll(pageable);
    }

}
