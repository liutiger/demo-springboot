package com.liuxl.mapper.mybatis;

import com.liuxl.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List selectAllUser();

    Page<User> selectPageUser(int pageSize, int pageNumber);
}