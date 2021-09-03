package com.xxxx.entity.vo;

/*
    模型
    1.状态码
    2.提示信息
    3.回显数据

 */


public class MessageModel {
    private Integer code=1;
    private String msg="成功" ;
    private Object object;
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

}
