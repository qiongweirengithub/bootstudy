package com.qw.study.shardingdb.app.web.vo;

import java.util.List;

/**
 * @author qunar-qw
 * @date 18-7-5
 */
public class ResponseVo<T> {

    private int count;
    private int statusCode;
    private String message;
    private List<T> data;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public static ResponseVo createSucc() {
        ResponseVo responseVo = new ResponseVo();
        responseVo.setStatusCode(1);
        responseVo.setMessage("succ");
        responseVo.setCount(0);
        return responseVo;
    }

    public static ResponseVo createSucc(List data ) {
        ResponseVo responseVo = new ResponseVo();
        responseVo.setStatusCode(1);
        responseVo.setMessage("succ");
        responseVo.setData(data);
        responseVo.setCount(data.size());
        return responseVo;
    }
    public static ResponseVo createFail() {
        ResponseVo responseVo = new ResponseVo();
        responseVo.setMessage("fail");
        responseVo.setStatusCode(0);
        responseVo.setCount(0);
        return responseVo;
    }
}