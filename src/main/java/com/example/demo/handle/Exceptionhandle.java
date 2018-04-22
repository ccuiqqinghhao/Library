package com.example.demo.handle;

import com.example.demo.entity.ResultEntity;
import com.example.demo.service.SysService;
import com.example.demo.util.ResultUtil;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

/**
 * 异常捕获
 */
@ControllerAdvice
public class Exceptionhandle {
    private static org.slf4j.Logger logger= LoggerFactory.getLogger(SysService.class);
    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public ResultEntity handle(Exception e){
        logger.info(e.getMessage());
        return ResultUtil.error(e.hashCode(),e.getMessage());
    }
}
