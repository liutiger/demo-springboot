package com.liuxl;

import com.google.common.base.Stopwatch;
import com.liuxl.common.demoEnum.DemoCode;
import com.liuxl.common.exception.DemoException;
import com.liuxl.entity.core.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author liuxl
 * @date 2019 /4/24
 */
@Component
@Aspect
public class ExceptionAspect {
    /**
     * The constant logger.
     */
    public static final Logger logger = LoggerFactory.getLogger(ExceptionAspect.class);

    /**
     * 此处基于自身项目的路径做具体的设置
     */
    @Pointcut("execution(* com.liuxl.service.*.*(..))")
    public void pointCut() {
    }

    /**
     * Handle controller method object.
     *
     * @param pjp the pjp
     * @return the object
     */
    @Around("pointCut()")
    public Result handleControllerMethod(ProceedingJoinPoint pjp) {
        Result obj;
        try {
            //调用执行目标方法
            obj = (Result) pjp.proceed();
        } catch (Throwable throwable) {
            obj = handlerException(pjp, throwable);
        }
        return obj;
    }

    private Result handlerException(ProceedingJoinPoint pjp, Throwable e) {
        Result result = new Result();
        result.setSuccess(false);
        if (e.getClass().isAssignableFrom(DemoException.class)) {
            logger.error("DemoException{方法：" + pjp.getSignature() + "， 参数：" + pjp.getArgs() + ",异常：" + e.getMessage() + "}", e);
            DemoException demoException = (DemoException) e;
            result.setErrCode(demoException.getCode());
            result.setErrMsg(demoException.getMsg());
        } else if (e instanceof RuntimeException) {
            logger.error("RuntimeException{方法：" + pjp.getSignature() + "， 参数：" + pjp.getArgs() + ",异常：" + e.getMessage() + "}", e);
            result.setErrCode(DemoCode.CALL_DAO_ERROR.getErrCode());
            result.setErrMsg(e.getMessage());
        } else {
            logger.error("异常{方法：" + pjp.getSignature() + "， 参数：" + pjp.getArgs() + ",异常：" + e.getMessage() + "}", e);
            result.setErrCode(DemoCode.CALL_DAO_ERROR.getErrCode());
            result.setErrMsg(e.getMessage());
        }
        result.setErrDetail(e.getStackTrace()[0].toString());
        return result;
    }
}
