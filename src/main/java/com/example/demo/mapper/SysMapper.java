package com.example.demo.mapper;
import com.example.demo.entity.Book;
import com.example.demo.entity.Sys;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface SysMapper {

    /**
     * 管理员登录
     * @param sys
     * @return
     */

    @Select("select * from sys where Sno=#{Sno} and password=#{password}")
    Sys sysLogin(Sys sys);

    /**
     * 管理员查询所有用户
     * @return
     */
    @Select("select Uno,Uname,Usex,Ubirth,Uphone,UPosition from User")
    List<User> sysSelectAllUser();

    /**
     * 管理员检索图书
     * 模糊查询
     * @param book
     * @return
     */
    @Select("select * from Book where bname like '%${bname}%'")
    List<Book> sysSelectBookByBname(Book book);

}
