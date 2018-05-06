package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @RequestMapping("/adminBorrow")
    public String adminBorrow(){
        return "adminBorrow";
    }
    @RequestMapping("/adminReturn")
    public String adminReturn(){
        return "adminReturn";
    }
    @RequestMapping("/adminredecorateBook")
    public String redecorateBook(){
        return "adminRedecorateBook";
    }
    @RequestMapping("/adminupdatePwd")
    public String updatePwd(){
        return "adminUpdatePwd";
    }

    @RequestMapping("/user")
    public String user(){
        return "user";
    }
    @RequestMapping("/userBothBooks")
    public String userBothBooks(){
        return "userBothBooks";
    }
    @RequestMapping("/userBR")
    public String userBR(){
        return "userBR";
    }
    @RequestMapping("/userInfo")
    public String userInfo(){
        return "userInfo";
    }
    @RequestMapping("/userBothBRLog")
    public String userBothBRLog(){
        return "userBothBRLog";
    }
    @RequestMapping("/userUpdatePwd")
    public String userUpdatePwd(){
        return "userUpdatePwd";
    }

}
