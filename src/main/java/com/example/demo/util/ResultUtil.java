package com.example.demo.util;

import com.example.demo.entity.ResultEntity;


public class ResultUtil {
    /**
     * 成功
     * @param object
     * @return
     */
    public static ResultEntity success(Object object){
        ResultEntity result=new ResultEntity();
        result.setCode(0);
        result.setData(object);
        result.setMsg("成功");
        return result;
    }
    public static ResultEntity success(){
        return success(null);
    }

    /**
     * 失败
     * @param code
     * @param msg
     * @return
     */
    public static ResultEntity error(Integer code,String msg){
        ResultEntity result=new ResultEntity();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

}
