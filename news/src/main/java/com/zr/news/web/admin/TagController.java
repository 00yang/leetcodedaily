package com.zr.news.web.admin;

import com.zr.news.po.Tag;
import com.zr.news.po.Type;
import com.zr.news.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class TagController {

    @Autowired
    private TagService tagService;

    @RequestMapping("/tags")
    public String tags(@PageableDefault(size = 3,sort = {"id"},direction = Sort.Direction.DESC)
                               Pageable pageable, Model model){
        model.addAttribute("page",tagService.listTag(pageable));
        return "admin/tags";
    }

    @GetMapping("/tags/input")
    public String input(Model model){
        model.addAttribute("tag",new Tag());
        return "admin/tags-input";

    }

    @PostMapping("/tags/add")
    public String add(@Valid Tag tag, BindingResult result, RedirectAttributes attributes){
        Tag tag1 = tagService.getTagByName(tag.getName());
        if(tag1!=null){
            result.rejectValue("name","nameError","不能添加重复的标签");
            System.out.println(result);
        }
        if(result.hasErrors()){
            return "admin/tags-input";
        }
        Tag tag2 =tagService.savaTag(tag);
        if(tag2==null) {
            attributes.addFlashAttribute("message", "新增失败");
        }else {
            attributes.addFlashAttribute("message","新增成功");
        }
        return "redirect:/admin/tags";
    }

    @RequestMapping("/tags/{id}/toUpdate")
    public String toUpdate(@PathVariable Long id,Model model){
        System.out.println("id:"+id);
        model.addAttribute("tag",tagService.getTag(id));
        System.out.println("根据id查得数据为:"+tagService.getTag(id));
        return "admin/tags-input";
    }

    @RequestMapping("/tags/update/{id}")
    public String update(@Valid Tag tag, BindingResult result, @PathVariable Long id, RedirectAttributes attributes){
        System.out.println("传入tag:"+tag);
        Tag tag1 =tagService.getTagByName(tag.getName());
        if(tag1!=null){
            result.rejectValue("name","nameError","不能添加重复的标签");
        }
        if(result.hasErrors()){
            return "admin/tags-input";
        }
        Tag tag2 = tagService.updateTag(id,tag);
        if(tag2!=null){
            attributes.addFlashAttribute("message","更新成功");
        }
        else {
            attributes.addFlashAttribute("message","更新失败");
        }
        return "redirect:/admin/tags";
    }

}
