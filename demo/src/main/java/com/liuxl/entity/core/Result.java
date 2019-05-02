package com.liuxl.entity.core;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author liuxl
 * @date 2019/4/24
 */
public class Result<T> implements Serializable {
    private boolean success = true;

    private String errCode;

    private String errMsg;

    private String errDetail;

    private T module;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getErrDetail() {
        return errDetail;
    }

    public void setErrDetail(String errDetail) {
        this.errDetail = errDetail;
    }

    public T getModule() {
        return module;
    }

    public void setModule(T module) {
        this.module = module;
    }
}
