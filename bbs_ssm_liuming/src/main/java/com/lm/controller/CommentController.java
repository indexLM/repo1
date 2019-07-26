package com.lm.controller;

import com.lm.bean.Comment;
import com.lm.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RequestMapping("/commentController")
@Controller
public class CommentController {
    @Autowired
    CommentService commentService;

    //按帖子id（fid）查询评论表信息
    @RequestMapping("/getCommentFid")
    public void getCommentFid(int fid, Map<Object, Object> map) {
        List<Comment> listComment = commentService.getCommentFid(fid);
        map.put("listComment", listComment);
    }

    //添加评论
    @RequestMapping("/setComment")
    public String setComment(Comment comment) {
        commentService.setComment(comment);
        return "redirect:/index.jsp";
    }

    //按pid删除评论表
    @RequestMapping("/deleteComment")
    public ModelAndView deleteComment(Comment comment) {
        commentService.deleteComment(comment.getPid());
        //重定向到getMyself这个方法
        return new ModelAndView("redirect:/userController/getMyself");
    }
}
