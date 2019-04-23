package com.liuxl.controller;

import com.liuxl.entity.User;
import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author liuxl
 * @date 2019/3/4
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/testBoot")
public class TestBootController {

    @RequestMapping("/getUser")
    public User getUser() {
        User user = new User();
        user.setName("test");
        return user;
    }
}
