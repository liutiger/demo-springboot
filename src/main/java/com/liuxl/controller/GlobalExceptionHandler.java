package com.liuxl.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * Description:作为一个控制层的切面处理
 *
 * @author liuxl
 * @date 2019 /4/23
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 定义错误显示页，error.html
     */
    public static final String DEFAULT_ERROR_VIEW = "error";

    /**
     * 所有的异常都是Exception子类
     *
     * @param request the request
     * @param e       the e
     * @return the model and view
     */
    @ExceptionHandler(Exception.class)
    public Object defaultErrorHandler(HttpServletRequest request, Exception e) {
        class ErrorInfo {
            private Integer code;
            private String message;
            private String url;

            public Integer getCode() {
                return code;
            }

            public void setCode(Integer code) {
                this.code = code;
            }

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
        ErrorInfo info = new ErrorInfo();
        // 标记一个错误信息类型
        info.setCode(100);
        info.setMessage(e.getMessage());
        info.setUrl(request.getRequestURL().toString());
        
        return info;

    }
//    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) {
//        // 出现异常之后会跳转到此方法
//        // 设置跳转路径
//        ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);
//        // 将异常对象传递过去
//        mav.addObject("exception", e);
//        // 获得请求的路径
//        mav.addObject("url", request.getRequestURL());
//        return mav;
//    }
}
