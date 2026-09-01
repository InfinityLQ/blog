package com.blog;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;*/
/*import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;*/

@SpringBootApplication
/*(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})*/
public class BlogApplication {
    public static void main(String[] args) {
    	System.setProperty("spring.datasource.password", "011024");
        SpringApplication.run(BlogApplication.class, args);
        System.out.println("========================================");
        System.out.println("✅ 博客系统启动成功！");
        System.out.println("📍 访问地址: http://localhost:8080");
        System.out.println("📍 管理后台: http://localhost:8080/admin");
        System.out.println("========================================");
    }
}