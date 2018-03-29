package com.example.demo.mapper;
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
}
