package com.liuxl;

import com.liuxl.base.core.Result;
import com.liuxl.common.exception.DemoException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author liuxl
 * @date 2019/4/24
 */
@ControllerAdvice
public class DemoControllerAdvice {
    /**
     * 全局异常捕捉处理
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map errorHandler(Exception ex) {
        Map map = new HashMap();
        map.put("msg", ex.getMessage());
        map.put("details", ex.getStackTrace());
        return map;
    }

    /**
     * 拦截捕捉自定义异常 DemoException.class
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = DemoException.class)
    public Map myErrorHandler(DemoException ex) {
        Map map = new HashMap();
        map.put("code", ex.getCode());
        map.put("msg", ex.getMsg());
        return map;
    }
}
