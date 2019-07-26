package com.lm.service.impl;

import com.lm.bean.Comment;
import com.lm.dao.CommentMapper;
import com.lm.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    //按帖子id（fid）查询评论表信息
    @Override
    public List<Comment> getCommentFid(int fid) {
        return commentMapper.selectByCommentFid(fid);
    }

    //按用户id（userid）查询评论表的fid信息
    @Override
    public List<Comment> getCommentUserid(int userid) {
        return commentMapper.selectByCommentUserid(userid);
    }

    //添加评论
    @Override
    public void setComment(Comment comment) {
        commentMapper.insert(comment);
    }

    //按pid删除评论表
    @Override
    public void deleteComment(int pid) {
        commentMapper.deleteByPrimaryKey(pid);
    }

    //删除该用户对应的所有评论信息(按userid)
    @Override
    public void deleteCommentUserid(int userid) {
        commentMapper.deleteByUserid(userid);
    }
}
