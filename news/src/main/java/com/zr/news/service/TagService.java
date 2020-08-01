package com.zr.news.service;

import com.zr.news.po.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TagService {

    Page<Tag> listTag(Pageable pageable);

    Tag savaTag(Tag tag);

    void deleteTag(Long id);

    Tag getTagByName(String name);

    Tag getTag(Long id);

    Tag updateTag(Long id,Tag tag);

    List<Tag> listTag();

    List<Tag> listTag(String ids);



}
