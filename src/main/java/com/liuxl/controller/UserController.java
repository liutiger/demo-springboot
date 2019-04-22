package com.liuxl.controller;

import com.github.pagehelper.PageInfo;
import com.liuxl.entity.User;
import com.liuxl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author liuxl
 * @date 2019/3/4
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(path = "/getUser/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        User user = userService.queryById(id);
        return user;
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public List<User> getList() {
        List<User> user = userService.queryList();
        return user;
    }

    @RequestMapping(path = "/page", method = RequestMethod.GET)
    public PageInfo getpage(int pageSize, int pageNumber) {
        PageInfo user = userService.queryPage(pageSize, pageNumber);
        return user;
    }
}
