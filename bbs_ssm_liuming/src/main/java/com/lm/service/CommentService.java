package com.lm.service;

import com.lm.bean.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getCommentFid(int fid);//按帖子id（fid）查询评论表信息
    List<Comment> getCommentUserid(int userid);//按用户id（userid）查询评论表的fid信息
    void setComment(Comment comment);//添加评论
    void deleteComment(int pid);//按pid删除评论表
    void deleteCommentUserid(int userid); //删除该用户对应的所有评论信息(按userid)
}
