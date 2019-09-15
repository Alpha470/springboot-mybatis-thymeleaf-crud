package com.alpha.springboottest1.controller;

import com.alpha.springboottest1.model.Article;
import com.alpha.springboottest1.service.ArtcileMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class HelloController {

    @Resource
    private ArtcileMapper artcileMapper;

    //添加页面
    @RequestMapping ( "add" )
    public String add() {
        return "add";
    }

    //查找(用于查询)
    @RequestMapping ( "getArticle" )
    public String getArticle(int id, Model model) throws Exception {
        Article article = artcileMapper.getArticleById(id);
        model.addAttribute("article", article);
        return "articleShow";
    }

    //添加
    @RequestMapping ( "addArticle" )
    public String listArticle(Article article, BindingResult bindingResult) throws Exception {
        boolean flag = artcileMapper.insertArtcile(article) > 0;
        return "redirect:listArticle";
    }

    //删除
    @RequestMapping ( "deleteArticle" )
    public String deleteArticle(Article article) throws Exception {
        artcileMapper.deleteArtcile(article.getId());
        return "redirect:listArticle";
    }

    //修改
    @RequestMapping ( "updateArticle" )
    public String updateArticle(Article article) throws Exception {
        boolean flag = artcileMapper.updateArtcile(article) > 0;
        return "redirect:listArticle";
    }

    //查找(用于修改)
    @RequestMapping ( "findArticle" )
    public String findArticle(int id, Model model) throws Exception {
        Article article = artcileMapper.getArticleById(id);
        model.addAttribute("article", article);
        return "modify";
    }

    //遍历
    @RequestMapping ( "/listArticle" )
    public String listArticle(@RequestParam ( value = "title", defaultValue = "" ) String title,
                              Model model, @RequestParam ( value = "start", defaultValue = "1" ) int start,
                              @RequestParam ( value = "size", defaultValue = "5" ) int size) throws Exception {

        PageHelper.startPage(start, size);

        List<Article> articleList = artcileMapper.findArtcleBytitle(title);
        PageInfo<Article> page = new PageInfo<>(articleList);
        System.out.println("总数量：" + page.getTotal());
        System.out.println("当前页查询记录：" + page.getList().size());
        System.out.println("当前页码：" + page.getPageNum());
        System.out.println("每页显示数量：" + page.getPageSize());
        System.out.println("总页：" + page.getPages());
        model.addAttribute("pages", page);
        model.addAttribute("title", title);
        return "index";
    }


}
