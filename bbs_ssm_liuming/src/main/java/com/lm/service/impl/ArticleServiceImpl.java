package com.lm.service.impl;

import com.lm.bean.Article;
import com.lm.dao.ArticleMapper;
import com.lm.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;

    //向数据库插入发帖信息
    @Override
    public void setArticle(Article article) {
        articleMapper.insert(article);
    }

    //查询发帖表信息（无条件）
    @Override
    public List<Article> getArticle() {
        return articleMapper.selectByArticle();
    }

    //按帖子标题模糊查询（搜索框搜索）
    @Override
    public List<Article> getArticleTitle(String articleTitle) {
        return articleMapper.selectByArticleTitle(articleTitle);
    }

    //按帖子板块查询出帖子
    @Override
    public List<Article> getArticleBname(String bname) {
        return articleMapper.selectByArticleBname(bname);
    }

    //按userid查询发帖表信息
    @Override
    public List<Article> getArticleId(int userid) {
        return articleMapper.selectByArticleId(userid);
    }

    //按fid查询发帖表信息
    @Override
    public Article getArticleKey(int fid) {
        return articleMapper.selectByPrimaryKey(fid);
    }

    //按fid删除帖子
    @Override
    public void deleteArticle(int fid) {
        articleMapper.deleteByPrimaryKey(fid);
    }

    //修改帖子表
    @Override
    public void updateArticle(Article article) {
        articleMapper.updateByPrimaryKey(article);
    }

    //修改article表的status属性（修改审核状态）
    @Override
    public void updateArticleStatus(Article article) {
        articleMapper.updateArticleStatus(article);
    }

    //删除用户对应的帖子信息(按userid)
    @Override
    public void deleteArticleUserid(int userid) {
        articleMapper.deleteByUserid(userid);
    }
    //修改article表中的username
    @Override
    public void updateArticleSetup(Article article) {
        articleMapper.updateArticleSetup(article);
    }
}
