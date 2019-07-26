package com.lm.service;

import com.lm.bean.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> getAdmin(Admin admin);//管理员登录查询
    List<Admin> getAdminName(Admin admin);//管理员注册按姓名查询
    void setAdmin(Admin admin);//管理员注册插入
}
