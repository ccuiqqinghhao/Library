package com.example.demo.controller;


import com.example.demo.entity.ResultEntity;
import com.example.demo.entity.Sys;
import com.example.demo.entity.User;
import com.example.demo.service.SysService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@RestController
public class LoginAndRegisterController {
    @Autowired
    SysService sysService;
    @Autowired
    UserService userService;
    @ResponseBody
    @PostMapping(value="/sys/login")
    public ResultEntity sysLogin( @RequestParam String no,
                                  @RequestParam String pwd, HttpSession httpSession){
       Sys sys=new Sys();
       sys.setSno(no);
       sys.setSpwd(pwd);
       return sysService.login(sys,httpSession);
    }
    //todo可能会写一个用户登录
    @PostMapping(value="/user/login")
    public ResultEntity userLogin(@RequestParam String no,
                                  @RequestParam String pwd,HttpSession httpSession){
        User user=new User();
        user.setUno(no);
        user.setUpwd(pwd);
        return userService.login(user,httpSession);
    }
    /**
     * 清楚session
     * @param httpSession
     * @return
     */
    @PostMapping(value="/exit")
    public ResultEntity exit(HttpSession httpSession){
        return sysService.clearSession(httpSession);
    }
}
