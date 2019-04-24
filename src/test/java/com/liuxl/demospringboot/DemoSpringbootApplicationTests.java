package com.liuxl.demospringboot;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.liuxl.entity.User;
import com.liuxl.entity.core.Result;
import com.liuxl.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoSpringbootApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
        Result<PageInfo>  page  = userService.queryPage(1,2);
        System.out.println(JSONObject.toJSONString(page));
    }

}
