package com.lm.service;

import com.lm.bean.Collect;

import java.util.List;

public interface CollectService {
    List<Collect> getCollect();//查询收藏信息（无条件）
    void deleteCollect(Collect collect);//删除收藏(按sid)
    void setCollect(Collect collect);//添加收藏
    List<Collect> getCollect(int userid);//按userid查询收藏信息（收藏了哪些帖子）
    void deleteCollectUseridAndFid(Collect collect);//删除收藏（按userid和fid）
    void deleteCollectFid(int fid);//按fid删除收藏信息
    void deleteCollectUserid(int userid);//删除该用户对应的收藏信息(按userid)
}
