package com.zr.news.web;

import com.zr.news.po.User;
import com.zr.news.service.NewService;
import com.zr.news.service.TagService;
import com.zr.news.service.TypeService;
import com.zr.news.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @Autowired
    private NewService newService;

    @GetMapping("/")
    public String index(@PageableDefault(size = 3,sort = {"updateTime"},direction = Sort.Direction.DESC)
                        Pageable pageable, Model model){
        model.addAttribute("page",newService.listNew(pageable));
        model.addAttribute("types",typeService.listTypeTop(3));
        model.addAttribute("tags",tagService.listTagTop(3));
        model.addAttribute("recommendNews",newService.listRecommendNewTop(3));
        return "index";
    }

    @PostMapping("/search")
    public String search(@PageableDefault(size = 3,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable,
                         @RequestParam String query,Model model){
        model.addAttribute("page",newService.listNew("%"+query+"%",pageable));
        model.addAttribute("query",query);
        return "search";

    }

    @RequestMapping("/news/{id}")
    public String news(@PathVariable Long id,Model model){
        model.addAttribute("news",newService.getAndConvert(id));
        return "new";
    }

}






















