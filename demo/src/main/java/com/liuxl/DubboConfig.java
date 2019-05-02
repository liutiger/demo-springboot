package com.liuxl;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author liuxl
 * @date 2019/5/2
 */
@Configuration
@ImportResource({"classpath:dubbo-provider.xml"})
public class DubboConfig {
}
