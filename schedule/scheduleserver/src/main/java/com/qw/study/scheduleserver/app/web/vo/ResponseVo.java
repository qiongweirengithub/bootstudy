package com.qw.study.scheduleserver.app.web.vo;

/**
 * @author qunar-qw
 * @date 18-7-12
 */
public class ResponseVo<T> {

    private Integer status;
    private String message;
    private T data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static ResponseVo createTrue(Object data) {
        ResponseVo vo =  new ResponseVo();
        vo.setStatus(1);
        vo.setMessage("success");
        vo.setData(data);
        return vo;
    }
}