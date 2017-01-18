package com.zm.dao;

import com.zm.entity.tUser;

public interface tUserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(tUser record);

    int insertSelective(tUser record);

    tUser selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(tUser record);

    int updateByPrimaryKey(tUser record);
}