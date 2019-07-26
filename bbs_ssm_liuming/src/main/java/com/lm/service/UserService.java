package com.lm.service;

import com.lm.bean.User;

import java.util.List;

public interface UserService {
    List<User> getUser(User user); //登录查询（按姓名和密码）

    List<User> getUserName(User user);//注册按用户名查询

    void setUser(User user);//注册插入

    List<User> getUser();//查询用户信息（无条件）

    List<User> getUserId(int userid);//按userid查询用户信息

    boolean getUser(String name); //按name查询用户

    void updateUser(User user);//编辑个人资料（修改user表）

    void deleteUser(User user);//删除用户

    void updateUserSetup(User user);//基本设置信息的修改

    User getUserKey(int userid);//按userid查询用户信息
}
