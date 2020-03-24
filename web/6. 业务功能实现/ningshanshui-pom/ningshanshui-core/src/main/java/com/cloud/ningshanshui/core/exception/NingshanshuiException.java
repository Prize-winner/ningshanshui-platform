package com.cloud.ningshanshui.core.exception;

/**
 * <p>Title: 自定义异常</p>
 * <p>Company: 纬度网络能源</p>
 *
 * @version 1.0
 * @KaiFaAuthor 宁山水
 * @date 2020-03-24 16:48
 */

public class NingshanshuiException extends RuntimeException {

    private String msg;
    private int code = 500;


    public NingshanshuiException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public NingshanshuiException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public NingshanshuiException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public NingshanshuiException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
