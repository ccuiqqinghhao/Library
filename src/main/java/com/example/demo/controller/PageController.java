package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/")
    public String adminLogin(){
        return "admin_Login";
    }
    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }
    @RequestMapping("/adminBooks")
    public String adminBooks(){
        return "admin_Books";
    }
    @RequestMapping("/adminBorrow")
    public String adminBorrow(){
        return "admin_Borrow";
    }
    @RequestMapping("/adminReturn")
    public String adminReturn(){
        return "admin_Return";
    }
    @RequestMapping("/adminUsers")
    public String adminUsers(){
        return "admin_Users";
    }


}
