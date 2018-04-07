package com.example.demo.controller;


import com.example.demo.entity.Book;
import com.example.demo.entity.ResultEntity;
import com.example.demo.entity.User;
import com.example.demo.service.SysService;

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
    @GetMapping(value="/selectUser/{Uno}")
    public ResultEntity sysSelectUserByUno(@PathVariable("Uno")String uno){
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
    @PostMapping(value="/updateUser/{Uno}")
    public ResultEntity updateUser(@PathVariable("Uno") String uno,
                                   @RequestParam("Uname") String uname,
                                   @RequestParam("Usex") String usex,
                                   @RequestParam("Ubirth") String ubirth,
                                   @RequestParam("Uphone")String uphone,
                                   @RequestParam("Uposition")String uposition){
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
    @PostMapping(value="/deleteUser/{uno}")
    public ResultEntity deleteUser(@PathVariable("uno") String uno) throws Exception{
        User user =new User();
        user.setUno(uno);
        return sysService.deleteUser(user);
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
    @PostMapping(value="updateBook/{ClassifyNo}")
    public ResultEntity updateBook(@PathVariable("ClassifyNo")String classifyNo,
                                   @RequestParam("Bname") String bname,
                                   @RequestParam("Bwriter")String bwriter,
                                   @RequestParam("BpubAdr")String bpubAdr,
                                   @RequestParam("BpubDate")String bpubDate,
                                   @RequestParam("Bprice")Integer bprice,
                                   @RequestParam("Btype")String btype) {
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
    @PostMapping(value="/deleteBook/{ClassifyNO}")
    public ResultEntity deleteBook(@PathVariable("ClassifyNo") String classifyNo){
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
    public ResultEntity borrowBook(@RequestParam("Uno")String uno,
                                   @RequestParam("ClassifyNo")String classifyNo){
        User user=new User();
        user.setUno(uno);
        Book book=new Book();
        book.setClassifyNo(classifyNo);
        return sysService.borrowBook(user,book);
    }

    /**
     * 图书归还
     * @param uno
     * @param classifyNo
     * @return
     */
    @PostMapping(value="/returnBook")
    public ResultEntity returnBook(@RequestParam("Uno")String uno,
                                   @RequestParam("ClassifyNo")String classifyNo){
        User user=new User();
        user.setUno(uno);
        Book book=new Book();
        book.setClassifyNo(classifyNo);
        return sysService.returnBook(user,book);
    }
}
