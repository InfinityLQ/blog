package com.blog.service;

import com.blog.entity.Article;
import com.blog.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public Page<Article> getArticles(int page, int size) {
        try {
            Pageable pageable = PageRequest.of(page, size, Sort.by("createTime").descending());
            Page<Article> result = articleRepository.findAll(pageable);
            return result != null ? result : new PageImpl<>(new ArrayList<>(), pageable, 0);
        } catch (Exception e) {
            return new PageImpl<>(new ArrayList<>(), PageRequest.of(page, size), 0);
        }
    }

    public List<Article> getAllArticles() {
        try {
            return articleRepository.findAll(Sort.by("createTime").descending());
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Transactional
    public Article getArticleById(Long id) {
        Optional<Article> optional = articleRepository.findById(id);
        if (optional.isPresent()) {
            Article article = optional.get();
            article.setViews(article.getViews() + 1);
            articleRepository.save(article);
            return article;
        }
        return null;
    }

    public Article saveArticle(Article article) {
        if (article.getId() == null) {
            article.setCreateTime(new Date());
        }
        article.setUpdateTime(new Date());
        return articleRepository.save(article);
    }

    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }
}