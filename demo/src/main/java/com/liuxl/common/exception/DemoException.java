package com.liuxl.common.exception;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author liuxl
 * @date 2019/4/24
 */
public class DemoException extends RuntimeException {

    public DemoException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;

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
}
