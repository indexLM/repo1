package com.lm.controller;

import com.lm.bean.Collect;
import com.lm.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/collectController")
@Controller
public class CollectController {
    @Autowired
    CollectService collectService;

    //删除收藏（按sid）
    @RequestMapping("/deleteCollect")
    public String deleteCollect(Collect collect) {

        collectService.deleteCollect(collect);
        return "redirect:/index.jsp";//重定向
    }

    //删除收藏（按userid和fid）
    @RequestMapping("/deleteCollectUseridAndFid")
    public String deleteCollectUseridAndFid(Collect collect) {
        collectService.deleteCollectUseridAndFid(collect);
        return "redirect:../userController/getMyself";//重定向
    }

    //添加收藏
    @RequestMapping("/setCollect")
    public String setCollect(Collect collect) {
        collectService.setCollect(collect);
        return "redirect:/index.jsp";//重定向
    }

}
