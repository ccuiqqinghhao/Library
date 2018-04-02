package com.example.demo.service;


import com.example.demo.entity.Book;
import com.example.demo.entity.ResultEntity;
import com.example.demo.entity.Sys;

import com.example.demo.entity.User;
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
    public ResultEntity login(Sys sys, HttpSession httpSession){

        logger.info("进入管理员登录服务");
        sys=sysMapper.login(sys);
        httpSession.setAttribute(Const.SYS_OBJECT,sys);
        return ResultUtil.success();
    }

    /**
     * 查询所有用户
     * @return
     */
    public ResultEntity selectAllUser(){
        logger.info("开始查询所有用户");
        return ResultUtil.success(sysMapper.selectAllUser());
    }

    /**
     * 根据Bname查询图书
     * @param book
     * @return
     */
    public ResultEntity selectBookByBname(Book book){
        logger.info("开始根据Bname查询图书");
        return ResultUtil.success(sysMapper.selectBookByBname(book));
    }

    /**
     * 根据ClassifyNo查询图书
     * @param book
     * @return
     */
    public ResultEntity selectBookByClassifyNo(Book book){
        logger.info("开始根据ClassifyNo查询图书");
        return ResultUtil.success(sysMapper.selectBookByClassifyNo(book));
    }

    /**
     * 更新图书信息
     * @param book
     * @return
     */
    public ResultEntity updateBook(Book book){
        logger.info("开始更新图书信息");
        if(sysMapper.updateBook(book)==1)
            return ResultUtil.success();
        return ResultUtil.error(100,"修改失败");
    }

    /**
     * 删除图书
     * @param book
     * @return
     */
    public ResultEntity deleteBook(Book book){
        logger.info("开始删除图书");
        if(sysMapper.deleteBook(book)==1)
            return ResultUtil.success();
        return  ResultUtil.error(100,"删除失败");
    }



    /**
     * 根据Uno查询User
     * @param user
     * @return
     */
    public ResultEntity selectUserByUno(User user){
        logger.info("开始根据Uno查询User");
        return ResultUtil.success(sysMapper.selectUserByUno(user));
    }
    /**
     * 更新用户
     * @param user
     * @return
     */
    public ResultEntity updateUser(User user){
        logger.info("开始更新User");
        if(sysMapper.updateUser(user)==1)
            return ResultUtil.success();
        return ResultUtil.error(100,"修改失败");
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    public ResultEntity insertUser(User user){
        logger.info("开始添加用户");
        if(sysMapper.insertUser(user)==1)
            return ResultUtil.success();
        return ResultUtil.error(100,"用户添加失败");
    }
}
