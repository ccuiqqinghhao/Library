package com.example.demo.controller;


import com.example.demo.entity.ResultEntity;
import com.example.demo.entity.Sys;
import com.example.demo.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@RestController
public class LoginAndRegisterController {
    @Autowired
    SysService sysService;

    @ResponseBody
    @PostMapping(value="/sys/login")
    public ResultEntity sysLogin( @RequestParam String no,
                                  @RequestParam String pwd, @SessionAttribute HttpSession httpSession){
       Sys sys=new Sys();
       sys.setSno(no);
       sys.setSpwd(pwd);
       return sysService.login(sys,httpSession);
    }
    //todo可能会写一个用户登录
}
