package com.example.demo.handle;

import com.example.demo.entity.ResultEntity;
import com.example.demo.util.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常捕获
 */
@ControllerAdvice
public class Exceptionhandle {
    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public ResultEntity handle(Exception e){
        return ResultUtil.error(e.hashCode(),e.getMessage());
    }
}
