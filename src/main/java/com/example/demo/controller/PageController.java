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
    @RequestMapping("/adminBookAdd")
    public String adminBookAdd(){
        return "adminBookAdd";
    }

    @RequestMapping("/adminUserAdd")
    public String adminUserAdd(){
        return "adminUserAdd";
    }
    @RequestMapping("/adminBothBooks")
    public String adminBothBooks(){
        return "adminBothBooks";
    }

    @RequestMapping("/adminBothUsers")
    public String adminBothUsers(){
        return "adminBothUsers";
    }

    @RequestMapping("/adminBRLog")
    public String adminBRLog(){
        return "adminBRLog";
    }
}
