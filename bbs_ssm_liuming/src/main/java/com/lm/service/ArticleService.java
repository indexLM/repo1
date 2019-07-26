package com.lm.service;

import com.lm.bean.Article;

import java.util.List;

public interface ArticleService {
    void setArticle(Article article);//向数据库插入发帖信息
    List<Article> getArticle();//查询发帖表信息（无条件）
    List<Article> getArticleTitle(String articleTitle);//按帖子标题模糊查询（搜索框搜索）
    List<Article> getArticleBname(String bname);//按帖子板块查询出帖子
    List<Article> getArticleId(int userid);//按userid查询发帖表信息
    Article getArticleKey(int fid); //按fid查询发帖表信息
    void deleteArticle(int fid); //按fid删除帖子
    void updateArticle(Article article); //修改帖子表
    void updateArticleStatus(Article article); //修改article表的status属性（修改审核状态）
    void deleteArticleUserid(int userid);//删除用户对应的帖子信息(按userid)
    void updateArticleSetup(Article article);//修改article表中的username
}
