package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {
    public final static Logger logger= LoggerFactory.getLogger(ServiceAspect.class);
    @Pointcut("execution(public * com.example.demo.service.*.*(..))")
    public void log(){}



    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {

        logger.info("Service_Class_methods={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        logger.info("Service_args={}",joinPoint.getArgs());
    }
}
