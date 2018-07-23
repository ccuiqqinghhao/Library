package com.example.demo.mapper;

import com.example.demo.entity.Sys;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
    /**
     * 用户登录
     * @param user
     * @return
     */
    @Select("select * from user where Uno=#{uno} and Upwd=#{upwd}")
    User login(User user);

    /**
     * user修改密码
     * @param user
     * @return
     */
    @Update("update user set Upwd=#{upwd} where Uno=#{uno}")
    Integer updateSyspwd(User user);
}
