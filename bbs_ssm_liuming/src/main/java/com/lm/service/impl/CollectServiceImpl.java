package com.lm.service.impl;

import com.lm.bean.Collect;
import com.lm.dao.CollectMapper;
import com.lm.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    CollectMapper collectMapper;

    //查询收藏信息（无条件）
    @Override
    public List<Collect> getCollect() {
        return collectMapper.selectByCollect();
    }

    //删除收藏(按sid)
    @Override
    public void deleteCollect(Collect collect) {
        collectMapper.deleteByCollect(collect);
    }

    //添加收藏
    @Override
    public void setCollect(Collect collect) {
        collectMapper.insert(collect);
    }

    //按userid查询收藏信息（收藏了哪些帖子）
    @Override
    public List<Collect> getCollect(int userid) {
        return collectMapper.selectByCollectUserid(userid);
    }

    //删除收藏（按userid和fid）
    @Override
    public void deleteCollectUseridAndFid(Collect collect) {
        collectMapper.deleteCollectUseridAndFid(collect);
    }

    //按fid删除收藏信息
    @Override
    public void deleteCollectFid(int fid) {
        collectMapper.deleteByCollectFid(fid);
    }

    //删除该用户对应的收藏信息(按userid)
    @Override
    public void deleteCollectUserid(int userid) {
        collectMapper.deleteCollectUserid(userid);
    }
}
