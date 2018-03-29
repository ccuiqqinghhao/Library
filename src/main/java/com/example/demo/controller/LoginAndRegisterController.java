package com.example.demo.controller;


import com.example.demo.entity.ResultEntity;
import com.example.demo.entity.Sys;
import com.example.demo.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
public class LoginAndRegisterController {
    @Autowired
    SysService sysService;

   @PostMapping(value="/sys/login")
    public ResultEntity sysLogin(@PathVariable("Sno") String sno,
                                 @PathVariable("Spwd") String spwd, HttpSession httpSession){
       Sys sys=new Sys();
       sys.setSno(sno);
       sys.setSpwd(spwd);
       return sysService.sysLogin(sys,httpSession);

    }
    //todo可能会写一个用户登录
}
