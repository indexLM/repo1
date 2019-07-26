package com.lm.service.impl;

import com.lm.bean.User;
import com.lm.dao.UserMapper;
import com.lm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    //登录查询（按姓名和密码）
    @Override
    public List<User> getUser(User user) {
        return userMapper.selectByUser(user);
    }

    //注册按用户名查询
    @Override
    public List<User> getUserName(User user) {
        return userMapper.selectByUserName(user);
    }

    //注册插入
    @Override
    public void setUser(User user) {
        userMapper.insert(user);
    }

    //查询所有用户信息（无条件）
    @Override
    public List<User> getUser() {
        return userMapper.selectByUserAll();
    }

    //按userid查询用户信息
    @Override
    public List<User> getUserId(int userid) {
        return userMapper.selectByUserId(userid);
    }

    public boolean getUser(String name) {
        User user = userMapper.selectByName(name);
        if (user != null) {
            return true;
        } else {
            return false;
        }
    }

    //编辑个人资料（修改user表）
    @Override
    public void updateUser(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    //删除用户
    @Override
    public void deleteUser(User user) {
        userMapper.deleteByPrimaryKey(user.getUserid());
    }

    //基本设置信息的修改
    @Override
    public void updateUserSetup(User user) {
        userMapper.updateSetupByPrimaryKey(user);
    }

    //按userid查询用户信息
    @Override
    public User getUserKey(int userid) {
        return userMapper.selectByPrimaryKey(userid);
    }
}
