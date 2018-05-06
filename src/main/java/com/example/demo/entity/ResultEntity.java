package com.example.demo.entity;



public class ResultEntity<T> {
    /**
     * 错误码
     */
    private Integer code;
    /**
     * 信息
     */
    private String msg;
    /**
     * 数据
     */
    private T data;


    public void setCode(Integer code) {
        this.code = code;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }
    public T getData() {
        return data;
    }
    public String getMsg() {
        return msg;
    }
}
