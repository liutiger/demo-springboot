package com.liuxl.rpc;

import com.liuxl.client.query.UserQuery;
import com.liuxl.entity.User;
import com.liuxl.entity.core.Result;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author liuxl
 * @date 2019/5/2
 */
public interface UserServiceRpc {
    Result<User> query(UserQuery query);
}
