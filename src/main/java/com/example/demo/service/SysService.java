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
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;


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
    //todo登录
        logger.info(sys.toString());
        logger.info("进入管理员登录服务");
        sys=sysMapper.login(sys);

        if(sys==null)
            throw new RuntimeException("用户名或密码错误");
        System.out.println(Const.SYS_OBJECT);
        httpSession.setAttribute(Const.SYS_OBJECT,sys);

        return ResultUtil.success();
    }

    /**
     * 查询所有图书
     * @return
     */
    public ResultEntity selectBothBooks(){
        return ResultUtil.success(sysMapper.selectBothBooks());
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

        List<Book> l=null;
        if((l=sysMapper.selectBookByClassifyNo(book)).isEmpty())
            throw new RuntimeException("找不到该图书或该图书已被删除");
        else
            return ResultUtil.success(l);
    }

    /**
     * 查询所有已借未还
     * @return
     */
    public ResultEntity selectBothUserBook(){
        logger.info("开始查询所有已借未还的信息");
        return ResultUtil.success(sysMapper.selectBothUserBook());
    }
    /**
     * 查询某一用户已借未还图书
     * @param user
     * @return
     */
    public ResultEntity selectUserBook(User user){
        logger.info("开始查询某用户已借未还的信息");
        return ResultUtil.success(sysMapper.selectUserBook(user));
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
        throw new RuntimeException("更新图书信息失败");
    }

    /**
     * 删除图书
     * @param book
     * @return
     */
    public ResultEntity deleteBook(Book book){
        logger.info("开始删除图书");
        book=sysMapper.selectBookByClassifyNo(book).get(0);
        if(book.getBborrowedNum()!=0)
            throw new RuntimeException("图书未全部归还,无法删除");
        if(sysMapper.deleteBook(book)!=1)
            throw new RuntimeException("删除失败");
        return ResultUtil.success();
    }

    /**
     * 添加图书
     * @param book
     * @return
     */
    public ResultEntity insertBook(Book book){
        if(sysMapper.selectBookByClassifyNo(book)==null){//不存在
            if(sysMapper.insertBook(book)==1)//添加成功
                return ResultUtil.success();
            else
                throw new RuntimeException("添加图书失败");
        }else{
            if(sysMapper.updateBookTotalNum(book)==1)
                return ResultUtil.success();
            else
                throw new RuntimeException("图书数量更新失败");

        }
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
     * 删除用户
     * @param user
     * @return
     * @throws Exception
     */
    public ResultEntity deleteUser(User user)throws Exception{
        if(sysMapper.selectUserNotReturn(user).size()!=0)
            throw new RuntimeException("该用户还有图书未归还,无法删除");
        logger.info("开始删除用户");
        if(sysMapper.deleteUser(user)==1)
            return ResultUtil.success();
        throw new RuntimeException("删除用户失败");
    }
    /**
     * 根据Uno查询User
     * @param user
     * @return
     */
    public ResultEntity selectUserByUno(User user){
        logger.info("开始根据Uno查询User");
        List<User> l=null;
        if((l=sysMapper.selectUserByUno(user)).isEmpty())
            throw new RuntimeException("找不到该用户或该用户已被删除");
        else
            return ResultUtil.success(l);
    }
    /**
     * 更新用户
     * @param user
     * @return
     */
    public ResultEntity updateUser(User user){
        logger.info("开始更新User");
        if(sysMapper.updateUser(user)>0)
            return ResultUtil.success();
        throw new RuntimeException("更新User信息失败");
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    public ResultEntity insertUser(User user){
        logger.info("开始添加用户");
        if(sysMapper.selectUserByUno(user).size()!=0)
            throw new RuntimeException("该用户id已存在");
        if(sysMapper.insertUser(user)==1)
            return ResultUtil.success();

        throw new RuntimeException("添加用户失败");


    }

    /**
     * 借阅图书
     * @param user
     * @param book
     * @return
     */
    @Transactional
    public ResultEntity borrowBook(User user,Book book){
        logger.info(user.toString()+"  "+book.toString());
        if(sysMapper.selectUserByUno(user).size()==0)
            throw new RuntimeException("找不到该用户");
        List<Book> l=sysMapper.selectBookByClassifyNo(book);
        if(l.size()==0)
            throw new RuntimeException("找不到图书信息");
        book=l.get(0);
        if(sysMapper.selectIsBorrowedThisBook(user.getUno(),book.getClassifyNo())==1)
            throw new RuntimeException("同样的书只可以借一本哦");
        if(book.getBborrowedNum()>=book.getBtotalNum())
            throw new RuntimeException("图书在馆数量不足,无法借阅");
        if(sysMapper.borrowBook(user.getUno(),book.getClassifyNo())==1)
            if(sysMapper.updateBookBorrowedNumWhenBorrow(book)==1&&
                    sysMapper.insertRdeleted(user.getUno(),book.getClassifyNo())==1)
                return ResultUtil.success();

        throw new RuntimeException("借阅失败");
    }

    /**
     * 还书操作
     * @param user
     * @param book
     * @return
     */
    @Transactional
    public ResultEntity returnBook(User user,Book book){
        if(sysMapper.updateRdeletedReturnTime(user.getUno(),book.getClassifyNo())==1)
            if(sysMapper.updateBookBorrowedNumWhenReturn(book)==1)
                if(sysMapper.deleteUserBook(user.getUno(),book.getClassifyNo())==1)
                    return ResultUtil.success();

        throw new RuntimeException("还书失败");

    }



    /**
     * 续借操作
     * @param user
     * @param book
     * @return
     */
    @Transactional
    public ResultEntity redecorateBook(User user,Book book){
        logger.info(user.toString()+"  "+book.toString());
        if(sysMapper.selectUReborrowTimesFromUserbook(user.getUno(),book.getClassifyNo())==1)
            throw new RuntimeException("已经续借过了");
        if(sysMapper.updateUserBookUReborrowTimesAndUExpectedReturnDate(user.getUno(),book.getClassifyNo())==1)
            if (sysMapper.updateRdeletedUReborrowTimes(user.getUno(), book.getClassifyNo())==1)
                return ResultUtil.success();

        throw new RuntimeException("续借失败");
    }

    /**
     * 查询所有日志
     * @return
     */
    public ResultEntity selectBothLog(){
        return ResultUtil.success(sysMapper.selectBothLog());
    }

    /**
     * 查询指定用户的借阅日志
     * @param user
     * @return
     */
    public ResultEntity selectUserLog(User user){
        return ResultUtil.success(sysMapper.selectUserLog(user));
    }
}
