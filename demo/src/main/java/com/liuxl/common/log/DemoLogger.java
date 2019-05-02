package com.liuxl.common.log;

import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author liuxl
 * @date 2019/4/23
 */
public class DemoLogger {
    public static Logger getT(T t) {
        return LoggerFactory.getLogger(T.class);
    }


}
