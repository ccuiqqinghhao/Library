package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.entity.ResultEntity;
import com.example.demo.entity.Sys;
import com.example.demo.entity.User;
import com.example.demo.service.SysService;
import com.example.demo.service.UserService;
import com.example.demo.util.Const;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value="/user")
public class UserController {
    @Autowired
    SysService sysService;

    @Autowired
    UserService userService;
    private static Logger logger =LoggerFactory.getLogger(UserController.class);


    /**
     * user修改密码
     * @param bpwd
     * @param npwd
     * @param httpSession
     * @return
     */
    @PostMapping(value="/UpdatePwd")
    public ResultEntity updatePwd(@RequestParam String bpwd,
                                  @RequestParam String npwd, HttpSession httpSession){
        User user=new User();
        user.setUpwd(bpwd);
        return userService.updateSyspwd(user,npwd,httpSession);
    }
    /**
     * 查询所有图书
     * @return
     */
    @GetMapping(value="/selectBothBooks")
    public ResultEntity selectBothBooks(){
        return sysService.selectBothBooks();
    }

    /**
     * 模糊搜索图书
     * @param bname
     * @return
     */
    @GetMapping(value="/SelectBookByBname/{bname}")
    public ResultEntity selectBookByBname(@PathVariable("bname") String bname){
        Book book=new Book();
        book.setBname(bname);
        return sysService.selectBookByBname(book);
    }
    @GetMapping(value="/selectBookByClassifyNo/{ClassifyNo}")
    public ResultEntity selectBookByClassifyNo(@PathVariable("ClassifyNo")String classifyNo){
        Book book=new Book();
        book.setClassifyNo(classifyNo);
        return sysService.selectBookByClassifyNo(book);
    }
    /**
     * 续借操作
     * @param uno
     * @param classifyNo
     * @return
     */
    @PostMapping(value="/redecorateBook")
    public ResultEntity redecorateBook(@RequestParam("uno")String uno,
                                       @RequestParam("classifyNo")String classifyNo){
        User user=new User();
        Book book=new Book();
        user.setUno(uno);
        book.setClassifyNo(classifyNo);
        return sysService.redecorateBook(user,book);
    }
    /**
     * 用户查询自己的信息
     * @return
     */
    @GetMapping(value="/selectUser")
    public ResultEntity selectUser(HttpSession httpSession){
        User user =(User)httpSession.getAttribute(Const.USER_OBJECT);
        return sysService.selectUserByUno(user);
    }

    /**
     * 更新用户信息
     * @param uno
     * @param uname
     * @param usex
     * @param ubirth
     * @param uphone
     * @param uposition
     * @return
     */
    @PostMapping(value="/updateUser")
    public ResultEntity updateUser(@RequestParam("uno") String uno,
                                   @RequestParam("uname") String uname,
                                   @RequestParam("usex") String usex,
                                   @RequestParam("ubirth") String ubirth,
                                   @RequestParam("uphone")String uphone,
                                   @RequestParam("uposition")String uposition){
        User user =new User();
        user.setUno(uno);
        user.setUname(uname);
        user.setUsex(usex);
        user.setUbirth(ubirth);
        user.setUphone(uphone);
        user.setUposition(uposition);
        return sysService.updateUser(user);

    }
    /**
     * 查询指定用户的已借未还的
     * @param httpSession
     * @return
     */
    @GetMapping(value="/selectBR")
    public ResultEntity selectBR(HttpSession httpSession){
        User user =(User)httpSession.getAttribute(Const.USER_OBJECT);
        return sysService.selectUserNotReturn(user);
    }

    /**
     *查询指定用户已借已还即所有的日志
     * @param httpSession
     * @return
     */
    @GetMapping(value="/selectBRLog")
    public ResultEntity selectBRLog(HttpSession httpSession){
        User user =(User)httpSession.getAttribute(Const.USER_OBJECT);
        return sysService.selectUserLog(user);
    }


}
