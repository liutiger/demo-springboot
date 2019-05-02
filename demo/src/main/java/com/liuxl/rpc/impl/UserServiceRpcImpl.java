package com.liuxl.rpc.impl;

import com.liuxl.client.query.UserQuery;
import com.liuxl.entity.User;
import com.liuxl.entity.core.Result;
import com.liuxl.rpc.UserServiceRpc;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author liuxl
 * @date 2019/5/2
 */
public class UserServiceRpcImpl implements UserServiceRpc {
    @Override
    public Result<User> query(UserQuery query) {
        System.out.println("调取成功");
        return null;
    }


}
