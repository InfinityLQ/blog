# 📝 个人博客系统

> 基于 Spring Boot 的个人博客系统，支持文章发布、分类管理和浏览量统计。

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.7.0-brightgreen)](https://spring.io/projects/spring-boot)

## ✨ 功能特性

- **文章管理**：发布、浏览、分类管理
- **浏览量统计**：自动记录每篇文章的访问量
- **响应式设计**：基于 Bootstrap 5，适配移动端

## 🛠️ 技术栈

- **后端**：Spring Boot 2.7, Spring Data JPA, MySQL 8.0
- **前端**：Thymeleaf, Bootstrap 5
- **构建工具**：Maven

## 🚀 快速开始

### 1. 克隆项目

```bash
git clone https://github.com/InfinityLQ/blog.git
cd blog


### 2. 项目结构
blog
├── pom.xml
├── src
│   └── main
│       ├── java
│       │   └── com
│       │       └── blog
│       │           ├── BlogApplication.java          # 启动类
│       │           ├── entity
│       │           │   └── Article.java              # 文章实体
│       │           ├── repository
│       │           │   └── ArticleRepository.java    # 数据访问层
│       │           ├── service
│       │           │   └── ArticleService.java       # 业务逻辑
│       │           └── controller
│       │               └── ArticleController.java    # 控制器
│       └── resources
│           ├── application.yml                       # 配置文件
│           └── templates
│               ├── index.html                        # 首页
│               ├── detail.html                       # 文章详情
│               ├── admin.html                        # 管理后台
│               └── publish.html                      # 发布文章


