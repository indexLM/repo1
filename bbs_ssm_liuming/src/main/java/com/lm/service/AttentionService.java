package com.lm.service;

import com.lm.bean.Attention;

import java.util.List;

public interface AttentionService {
    void setAttention(Attention attention);//添加关注
    List<Attention> getAttention();//查询关注信息(无条件)
    void deleteAttention(Attention attention);//取消关注(首页)
    List<Attention> getAttention(int userid);//按userid查询关注信息
    List<Attention> getAttentionBe(int beuserid);//按beuserid查询关注信息
    void deleteAttentionMyself(Attention attention);//取消关注（个人主页）
    void deleteAttentionUseridOrBeuserid(int userid);//删除该用户对应的关注和被关注信息
}
