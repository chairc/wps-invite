package com.example.wps.wps_invite.entity;

/**
 * @auther chairc
 * @date 2021/2/28 21:43
 */
//返回前端的验证结果集
public class ResultSet {

    private String code;            //返回码
    private String msg;             //返回信息
    private Object data = "";     //返回数据，默认设为空，需要返回数据时，使用setData()方法

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultSet{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * 自定义成功返回文本
     * @param msg 自定义文本
     */

    public void ok(String msg){
        this.code = "200";
        this.msg = msg;
    }

    /**
     * Bad Request 请求存在错误或参数错误
     * @param msg 自定义文本
     */

    public void fail(String msg){
        this.code = "400";
        this.msg = msg;
    }

    /**
     * OK 返回成功
     */

    public void ok() {
        this.code = "200";
        this.msg = "ok";
    }

    /**
     * Unauthorized 请求需要有HTTP认证或者认证失败
     */

    public void unauthorized() {
        this.code = "401";
        this.msg = "用户未登录，需要身份认证";
    }

    /**
     * 请求资源的访问被服务器拒绝
     */

    public void forbidden() {
        this.code = "403";
        this.msg = "服务器拒绝请求";
    }

    /**
     * 请求资源服务器未找到
     */

    public void notFound() {
        this.code = "404";
        this.msg = "请求资源不存在";
    }

    /**
     * 服务器执行请求出错
     */

    public void interServerError() {
        this.code = "500";
        this.msg = "服务器内部错误";
    }
}
