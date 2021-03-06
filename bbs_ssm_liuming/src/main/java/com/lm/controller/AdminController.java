package com.lm.controller;

import com.lm.bean.Admin;
import com.lm.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("adminController")
@SessionAttributes(value="adminList")
public class AdminController {

    @Autowired
    AdminService adminService;
    @Autowired
    PlateController plateController;
    @Autowired
    UserController userController;

    List<Admin> list=new ArrayList<Admin>();


        //管理员登录判断
    @RequestMapping("getLogin")
    public String getLogin(Admin admin, Map<Object, Object> map) {

        //调用管理员查询方法
        list=adminService.getAdmin(admin);
        String str=list.toString();
        if (!str.equals("[]")) {
            map.put("adminList", list.get(0));
            plateController.getPlate(map);
            userController.getUser(map);
            return "redirect:/admin/index.jsp";//重定向
        } else {
            return "redirect:/admin/index.jsp";//重定向
        }
    }

    //退出管理员登录
    @RequestMapping("/adminExit")
    public String adminExit(Map<Object, Object> map) {
        map.put("adminList", "");
        return "redirect:/admin/index.jsp";// 重定向
    }
}
