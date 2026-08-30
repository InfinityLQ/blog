package com.blog.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String title;
    
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    
    private String category;
    private String tags;
    
    private Integer views = 0;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time")
    private Date createTime;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_time")
    private Date updateTime;

    // ========== Getter ==========
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public String getCategory() { return category; }
    public String getTags() { return tags; }
    public Integer getViews() { return views; }
    public Date getCreateTime() { return createTime; }
    public Date getUpdateTime() { return updateTime; }

    // ========== Setter ==========
    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setContent(String content) { this.content = content; }
    public void setCategory(String category) { this.category = category; }
    public void setTags(String tags) { this.tags = tags; }
    public void setViews(Integer views) { this.views = views; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }
    public void setUpdateTime(Date updateTime) { this.updateTime = updateTime; }
}