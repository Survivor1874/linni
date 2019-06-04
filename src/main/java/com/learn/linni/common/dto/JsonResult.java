package com.learn.linni.common.dto;

import java.io.Serializable;

/**
 * Created by yangch on 16:54 2019-01-09
 **/
public class JsonResult implements Serializable {

    private static final long serialVersionUID = -9070835606799273459L;
    private Boolean result;
    private Integer errCode;
    private String errMessage;
    private Object data;

    public JsonResult(Object object) {
        this(true, null, null,object);
    }

    public JsonResult(int errCode, String errMessage) {
        this(false, errCode, errMessage, null);
    }

    public JsonResult(boolean result, Integer errCode, String errMessage) {
        this(false, errCode, errMessage, null);
    }

    public JsonResult(boolean result, Integer errCode, String errMessage, Object data) {
        this.result = result;
        this.errCode = errCode;
        this.errMessage = errMessage;
        this.data = data;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "result=" + result +
                ", errCode=" + errCode +
                ", errMessage='" + errMessage + '\'' +
                ", data=" + data +
                '}';
    }
}
