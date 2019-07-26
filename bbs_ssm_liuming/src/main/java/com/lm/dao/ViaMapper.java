package com.lm.dao;

import com.lm.bean.Via;

public interface ViaMapper {

    //删除用户对应的头像信息
    int deleteByPrimaryKey(Integer userid);

    //上传用户头像（插入）
    int insert(Via record);

    //按userid查询用户信息
    Via selectByPrimaryKey(Integer userid);

    //按userid修改用户头像信息（via）
    int updateByPrimaryKey(Via record);
}
