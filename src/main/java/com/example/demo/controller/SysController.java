package com.example.demo.controller;


import com.example.demo.entity.Book;
import com.example.demo.entity.ResultEntity;
import com.example.demo.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value="/sys")
public class SysController {
    @Autowired
    SysService sysService;


    @GetMapping(value="/BothUsers")
    public ResultEntity selectBothUsers(){
        return sysService.sysSelectAllUser();
    }

    @GetMapping(value="/SelectBookByBname/{bname}")
    public ResultEntity selectBookByBname(@PathVariable("bname") String bname){
        Book book=new Book();
        book.setBname(bname);
        return sysService.sysSelectBookByBname(book);
    }
}
