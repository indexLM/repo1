package com.lm.service.impl;

import com.lm.bean.Attention;
import com.lm.dao.AttentionMapper;
import com.lm.service.AttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttentionServiceImpl implements AttentionService {
    @Autowired
    AttentionMapper attentionMapper;

    //添加关注
    @Override
    public void setAttention(Attention attention) {
        attentionMapper.insert(attention);
    }

    //查询关注信息(无条件)
    @Override
    public List<Attention> getAttention() {
        return attentionMapper.selectByAttention();
    }

    //取消关注(首页)
    @Override
    public void deleteAttention(Attention attention) {
        attentionMapper.deleteByAttention(attention);
    }

    //按userid查询关注信息
    @Override
    public List<Attention> getAttention(int userid) {
        return attentionMapper.selectByUserid(userid);
    }

    //按beuserid查询关注信息
    @Override
    public List<Attention> getAttentionBe(int beuserid) {
        return attentionMapper.selectByBeuserid(beuserid);
    }

    //取消关注（个人主页）
    @Override
    public void deleteAttentionMyself(Attention attention) {
        attentionMapper.deleteByAttentionMyself(attention);
    }

    //删除该用户对应的关注和被关注信息
    @Override
    public void deleteAttentionUseridOrBeuserid(int userid) {
        attentionMapper.deleteAttentionUseridOrBeuserid(userid);
    }
}
