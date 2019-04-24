package com.liuxl.service.impl;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuxl.base.DemoAbstractService;
import com.liuxl.common.exception.DemoException;
import com.liuxl.entity.User;
import com.liuxl.mapper.mybatis.UserMapper;
import com.liuxl.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author liuxl
 * @date 2019/3/4
 */
@Service("userService")
public class UserServiceImpl extends DemoAbstractService implements UserService {
    //给类初始化日志对象
    private final static Logger logger = Logger.getLogger(UserService.class);
    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> queryList() {
        return userMapper.selectAllUser();
    }

    @Override
    public PageInfo queryPage(int pageSize, int pageNumber) {
        Page<User> result = PageHelper.startPage(pageNumber, pageSize).doSelectPage(new ISelect() {
            @Override
            public void doSelect() {
                userMapper.selectAllUser();
            }
        });
        PageInfo page = new PageInfo(result);
        throw new DemoException("101","测试错误信息");
//        return page;
    }
}
