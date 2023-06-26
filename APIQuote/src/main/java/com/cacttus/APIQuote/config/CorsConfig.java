package com.cacttus.APIQuote.config;

import com.cacttus.APIQuote.ApiQuoteApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(ApiQuoteApplication.class, args);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/quote/**")
                .allowedOrigins("http://127.0.0.1:5500")
                .allowedMethods("GET", "POST")
                .allowedHeaders("*");
    }
}
