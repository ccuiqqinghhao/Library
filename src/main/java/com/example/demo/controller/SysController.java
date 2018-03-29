package com.example.demo.controller;


import com.example.demo.entity.ResultEntity;
import com.example.demo.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/sys")
public class SysController {
    @Autowired
    SysService sysService;


    @GetMapping(value="/BothUsers")
    public ResultEntity selectBothUsers(){
        return sysService.sysSelectAllUser();
    }
}
