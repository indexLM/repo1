package com.lm.service;

import com.lm.bean.Via;

public interface ViaService {
    Via getVia(int userid);//按userid查询用户头像信息（via）
    void setUserPhoto(Via via);//上传用户头像（插入）（via）
    void updateVia(Via via);//按userid修改用户头像信息（via）
    void deleteVia(Integer userid);//删除用户对应的头像信息
}
