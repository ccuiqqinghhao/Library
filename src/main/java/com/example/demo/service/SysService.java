package com.example.demo.service;


import com.example.demo.entity.Book;
import com.example.demo.entity.ResultEntity;
import com.example.demo.entity.Sys;

import com.example.demo.mapper.SysMapper;
import com.example.demo.util.Const;
import com.example.demo.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;


@Service
public class SysService {
    @Autowired
    SysMapper sysMapper;
    private static Logger logger= LoggerFactory.getLogger(SysService.class);

    /**
     * 管理员登录
     * @param sys
     * @param httpSession
     * @return
     */
    public ResultEntity sysLogin(Sys sys, HttpSession httpSession){

        logger.info("进入管理员登录服务");
        sys=sysMapper.sysLogin(sys);
        httpSession.setAttribute(Const.SYS_OBJECT,sys);
        return ResultUtil.success();
    }

    /**
     * 查询所有用户
     * @return
     */
    public ResultEntity sysSelectAllUser(){
        logger.info("开始查询所有用户");
        return ResultUtil.success(sysMapper.sysSelectAllUser());
    }

    public ResultEntity sysSelectBookByBname(Book book){
        logger.info("开始根据Bname查询图书");
        return ResultUtil.success(sysMapper.sysSelectBookByBname(book));
    }
}
