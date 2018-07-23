package com.example.demo;

import com.example.demo.util.MyInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;


@SpringBootApplication

@MapperScan("com.example.demo.mapper")
public class DemoApplication {
	static class WebMvcConfigurer implements org.springframework.web.servlet.config.annotation.WebMvcConfigurer {
		//增加拦截器
		public void addInterceptors(InterceptorRegistry registry){
			registry.addInterceptor(new MyInterceptor())    //指定拦截器类
					.addPathPatterns("/");        //指定该类拦截的url
		}
	}


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}




}
