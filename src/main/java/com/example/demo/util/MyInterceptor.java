package com.example.demo.util;

import com.example.demo.entity.Sys;
import com.example.demo.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyInterceptor implements HandlerInterceptor {
    private static Logger logger = LoggerFactory.getLogger(MyInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        logger.info("进入页面权限拦截器");
        String uri=request.getRequestURI();
        logger.info("页面权限拦截器|请求的url是:"+uri);
        HttpSession session=request.getSession();
        if(uri.contains("/admin")||uri.contains("/sys")){
            Object obj=session.getAttribute(Const.SYS_OBJECT);
            if(obj==null){
                logger.info("页面权限拦截器|session中不存在sys对象，无权限");
                response.sendRedirect(request.getContextPath()+"/");
                return false;
            }else{
                if(obj instanceof Sys){
                    logger.info("页面权限拦截器|放行，Sys权限");
                    return true;
                }else{
                    logger.info("页面权限拦截器|session中Sys对象不是Sys类");
                    response.sendRedirect(request.getContextPath()+"/");
                    return false;
                }
            }
        }else if(uri.contains("/user")){
            Object obj=session.getAttribute(Const.USER_OBJECT);
            if(obj==null){
                logger.info("页面权限拦截器|session中不存在User对象，无权限");
                response.sendRedirect(request.getContextPath()+"/");
                return false;
            }else{
                if(obj instanceof User){
                    logger.info("页面权限拦截器|放行，User权限");
                    return true;
                }else{
                    logger.info("页面权限拦截器|session中User对象不是User类");
                    response.sendRedirect(request.getContextPath()+"/");
                    return false;
                }
            }
        }
        logger.info("页面权限拦截器|url无法匹配User或Sys，url为"+uri);
        response.sendRedirect(request.getContextPath()+"/");
        return false;


    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}
