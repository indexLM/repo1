package com.lm.service.impl;

import com.lm.bean.Admin;
import com.lm.dao.AdminMapper;
import com.lm.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    //管理员登录查询
   @Override
    public List<Admin> getAdmin(Admin admin) {
        return adminMapper.selectByAdmin(admin);
    }

    //管理员注册按姓名查询
    @Override
    public List<Admin> getAdminName(Admin admin) {
        return adminMapper.selectByAdminName(admin);
    }

    //管理员注册插入
    @Override
    public void setAdmin(Admin admin) {
        adminMapper.insert(admin);
    }
}
