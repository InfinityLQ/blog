package com.blog.controller;

import com.blog.entity.Article;
import com.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/")
    public String index(@RequestParam(defaultValue = "0") int page, Model model) {
        List<Article> articleList = new ArrayList<>();
        int totalPages = 0;
        try {
            Page<Article> articlePage = articleService.getArticles(page, 10);
            if (articlePage != null) {
                articleList = articlePage.getContent();
                totalPages = articlePage.getTotalPages();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("articles", articleList);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        return "index";
    }

    @GetMapping("/article/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Article article = articleService.getArticleById(id);
        if (article == null) {
            return "redirect:/";
        }
        model.addAttribute("article", article);
        return "detail";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("articles", articleService.getAllArticles());
        return "admin";
    }

    @GetMapping("/admin/publish")
    public String publishPage() {
        return "publish";
    }

    @PostMapping("/admin/publish")
    public String publish(Article article) {
        articleService.saveArticle(article);
        return "redirect:/admin";
    }

    @GetMapping("/admin/delete/{id}")
    public String delete(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return "redirect:/admin";
    }
}