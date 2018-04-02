package com.example.demo.mapper;
import com.example.demo.entity.Book;
import com.example.demo.entity.Sys;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface SysMapper {

    /**
     * 管理员登录(还未实现)
     * @param sys
     * @return
     */

    @Select("select * from sys where Sno=#{Sno} and password=#{password}")
    Sys login(Sys sys);

    /**
     * 管理员查询所有用户
     * @return
     */
    @Select("select Uno,Uname,Usex,Ubirth,Uphone,UPosition from User")
    List<User> selectAllUser();

    /**
     * 根据Uno查询User
     * @param user
     * @return
     */
    @Select("select Uno,Uname,Usex,Ubirth,Uphone,UPosition from User where Uno =#{uno}")
    User selectUserByUno(User user);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @Update("update user set Uname =#{uname},Usex=#{usex},Ubirth=#{ubirth},Uphone=#{uphone},UPosition=#{uposition} where Uno=#{uno}")
    Boolean updateUser(User user);





    /**
     * 管理员检索图书
     * 模糊查询
     * @param book
     * @return
     */
    @Select("select * from Book where bname like '%${bname}%'")
    List<Book> selectBookByBname(Book book);

    /**
     * 根据CLassifyNo查询图书
     * @param book
     * @return
     */
    @Select("select * from book where ClassifyNo=#{classifyNo}")
    Book selectBookByClassifyNo(Book book);

    /**
     * 更新图书信息
     * @param book
     * @return
     */
    @Update("update book set Bname=#{bname},Bwriter=#{bwriter},BpubAdr=#{bpubAdr},BpubDate=#{bpubDate},Bprice=#{bprice},Btype=#{btype} where ClassifyNo=#{classifyNo}")
    Boolean updateBook(Book book);








}
