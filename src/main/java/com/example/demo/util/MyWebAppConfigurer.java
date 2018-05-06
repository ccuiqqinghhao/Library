package com.example.demo.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class MyWebAppConfigurer  extends WebMvcConfigurerAdapter{
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/Library",
                                                                                                "/sys/login",
                                                                                                "/css/**",
                                                                                                "/images/**",
                                                                                                "/",
                                                                                                "/user/login",
                                                                                                "/exit",
                                                                                                "/js/**",
                                                                                                "/fonts/**",
                                                                                                "/error");
        super.addInterceptors(registry);
    }
}
