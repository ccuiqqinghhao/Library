package com.example.demo.controller;


import com.example.demo.entity.Book;
import com.example.demo.entity.ResultEntity;
import com.example.demo.entity.User;
import com.example.demo.service.SysService;

import com.example.demo.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value="/sys")
public class SysController {
    @Autowired
    SysService sysService;

    /**
     * 查询所有用户
     * @return
     */
    @GetMapping(value="/BothUsers")
    public ResultEntity selectBothUsers(){
        return sysService.selectAllUser();
    }
    /**
     * 根据Uno查询User
     * @param uno
     * @return
     */
    @GetMapping(value="/selectUser/{uno}")
    public ResultEntity sysSelectUserByUno(@PathVariable("uno")String uno){
        User user=new User();
        user.setUno(uno);
        return sysService.selectUserByUno(user);
    }
    /**
     *更新用户
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
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping(value="/insertUser")
    public ResultEntity insertUser(@Valid User user){
        return sysService.insertUser(user);
    }

    /**
     * 删除用户
     * @param uno
     * @return
     * @throws Exception
     */
    @PostMapping(value="/deleteUser")
    public ResultEntity deleteUser(@RequestParam("uno") String uno) throws Exception{
        User user =new User();
        user.setUno(uno);
        return sysService.deleteUser(user);
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
     * 根据图书名模糊查询
     * @param bname
     * @return
     */
    @GetMapping(value="/SelectBookByBname/{bname}")
    public ResultEntity selectBookByBname(@PathVariable("bname") String bname){
        Book book=new Book();
        book.setBname(bname);
        return sysService.selectBookByBname(book);
    }

    /**
     * 根据CLassifyNo查询图书
     * @param classifyNo
     * @return
     */
    @GetMapping(value="/selectBookByClassifyNo/{ClassifyNo}")
    public ResultEntity selectBookByClassifyNo(@PathVariable("ClassifyNo")String classifyNo){
        Book book=new Book();
        book.setClassifyNo(classifyNo);
        return sysService.selectBookByClassifyNo(book);
    }

    /**
     * 更新图书信息
     * @param classifyNo
     * @param bname
     * @param bwriter
     * @param bpubAdr
     * @param bpubDate
     * @param bprice
     * @param btype
     * @return
     */
    @PostMapping(value="/updateBook")
    public ResultEntity updateBook(@RequestParam("classifyNo")String classifyNo,
                                   @RequestParam("bname") String bname,
                                   @RequestParam("bwriter")String bwriter,
                                   @RequestParam("bpubAdr")String bpubAdr,
                                   @RequestParam("bpubDate")String bpubDate,
                                   @RequestParam("bprice")Integer bprice,
                                   @RequestParam("btype")String btype) {
        Book book = new Book();
        book.setClassifyNo(classifyNo);
        book.setBname(bname);
        book.setBwriter(bwriter);
        book.setBpubAdr(bpubAdr);
        book.setBpubDate(bpubDate);
        book.setBprice(bprice);
        book.setBtype(btype);
        return sysService.updateBook(book);
    }

    /**
     * 删除图书
     * @param classifyNo
     * @return
     */
    @PostMapping(value="/deleteBook")
    public ResultEntity deleteBook(@RequestParam("classifyNo")String classifyNo){
        Book book=new Book();
        book.setClassifyNo(classifyNo);
        return sysService.deleteBook(book);
    }

    /**
     * 添加图书
     * @param book
     * @return
     */
    @PostMapping(value="/insertBook")
    public ResultEntity insertBook(@Valid Book book){

        return sysService.insertBook(book);
    }

    /**
     * 借阅图书
     * @param uno
     * @param classifyNo
     * @return
     */
    @PostMapping(value="/borrowBook")
    public ResultEntity borrowBook(@RequestParam("uno")String uno,
                                   @RequestParam("classifyNo")String classifyNo){
        User user=new User();
        user.setUno(uno);
        Book book=new Book();
        book.setClassifyNo(classifyNo);
        return sysService.borrowBook(user,book);
    }

    /**
     * 查询所有已借未还
     * @return
     */
    @GetMapping(value="/selectBothUserBook")
    public ResultEntity selectBothUserBook(){
        return sysService.selectBothUserBook();
    }
    /**
     * 查询某一用户已借未还
     * @param uno
     * @return
     */
    @GetMapping(value="/selectUserBook/{uno}")
    public ResultEntity selectUserBook(@PathVariable("uno")String uno){
        User user=new User();
        user.setUno(uno);
        return sysService.selectUserBook(user);
    }
    /**
     * 图书归还
     * @param uno
     * @param classifyNo
     * @return
     */
    @PostMapping(value="/returnBook")
    public ResultEntity returnBook(@RequestParam("uno")String uno,
                                   @RequestParam("classifyNo")String classifyNo){
        User user=new User();
        user.setUno(uno);
        Book book=new Book();
        book.setClassifyNo(classifyNo);
        return sysService.returnBook(user,book);
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
     * 查询所有日志
     * @return
     */
    @GetMapping("/bothLog")
    public ResultEntity selectBothLog(){
        return sysService.selectBothLog();
    }

    /**
     * 查询指定用户的借阅记录
     * @param uno
     * @return
     */
    @GetMapping("/userLog/{uno}")
    public ResultEntity selecrUserLog(@PathVariable("uno")String uno){
        User user=new User();
        user.setUno(uno);
        return sysService.selectUserLog(user);
    }
}
