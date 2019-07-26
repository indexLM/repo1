package com.lm.dao;

import com.lm.bean.Admin;

import java.util.List;

public interface AdminMapper {
    //删除管理员
    int deleteByPrimaryKey(Integer aid);

    //管理员注册按姓名查询
    int insert(Admin record);

    //管理员登录查询
    List<Admin> selectByAdmin(Admin admin);

    //管理员注册按姓名查询
    List<Admin> selectByAdminName(Admin admin);
}
