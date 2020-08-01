package com.zr.news.service.impl;

import com.zr.news.dao.NewRepository;
import com.zr.news.po.News;
import com.zr.news.service.NewService;
import com.zr.news.vo.NewQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class NewServiceImpl implements NewService {

    @Autowired
    private NewRepository newRepository;

    //博客管理中的博客列表（包含了查询）
    @Override
    public Page<News> listNew(Pageable pageable, NewQuery newQuery) {
        return newRepository.findAll(new Specification<News>() {
            @Override
            public Predicate toPredicate(Root<News> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if(!"".equals(newQuery.getTitle())&&newQuery.getTitle()!=null){
                    predicates.add(cb.like(root.<String>get("title"),"%"+newQuery.getTitle()+"%"));
                }
                if(newQuery.getTypeId()!=null){
                    predicates.add(cb.equal(root.get("id"),newQuery.getTypeId()));
                }
                if(newQuery.isRecommend()){
                    predicates.add(cb.equal(root.get("recommend"),newQuery.isRecommend()));
                }
                cq.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }
        },pageable);
    }

    @Override
    public News saveNew(News news) {
        if(news.getId()==null){
            news.setCreateTime(new Date());
            news.setUpdateTime(new Date());
        }
        return newRepository.save(news);
    }

    @Override
    public News getNew(Long id) {
        return newRepository.findById(id).orElse(null);
    }

    @Override
    public News updateNew(Long id, News news) {
        News news1 = newRepository.findById(id).orElse(null);
        if(news1==null){
            System.out.println("未获得更新对象");
        }
        BeanUtils.copyProperties(news,news1);
        news1.setUpdateTime(new Date());
        return newRepository.save(news1);
    }
}























