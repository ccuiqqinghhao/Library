package com.example.demo.service;

import com.example.demo.entity.ResultEntity;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.util.Const;
import com.example.demo.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    SysService sysService;
    private static Logger logger= LoggerFactory.getLogger(UserService.class);

    /**
     * 用户登录逻辑
     * @param user
     * @param httpSession
     * @return
     */
    public ResultEntity login(User user, HttpSession httpSession){
        //todo登录
        logger.info(user.toString());
        logger.info("进入用户登录服务");
        user=userMapper.login(user);
        if(user==null)
            throw new RuntimeException("用户名或密码错误");
        user.setUpwd("");
        httpSession.setAttribute(Const.USER_OBJECT,user);
        httpSession.setAttribute("uno",user.getUno());
        return ResultUtil.success();
    }

    public ResultEntity updateSyspwd(User user, String npwd, HttpSession httpSession){
        //todo
        user.setUno(httpSession.getAttribute("uno")+"");
        user=userMapper.login(user);
        if(user==null)
            throw new RuntimeException("输入的原密码不正确");
        user.setUpwd(npwd);
        if(userMapper.updateSyspwd(user)==1){
            sysService.clearSession(httpSession);
            return ResultUtil.success();
        }
        throw new RuntimeException("未知原因修改失败");
    }
}
