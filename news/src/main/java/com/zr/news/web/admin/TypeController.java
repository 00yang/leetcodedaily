package com.zr.news.web.admin;

import com.zr.news.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @RequestMapping("/types")
    public String type(@PageableDefault(size = 3,sort = {"id"},direction = Sort.Direction.DESC)
                       Pageable pageable, Model model){
        model.addAttribute("page",typeService.listType(pageable));

        return "admin/types";
    }
}
