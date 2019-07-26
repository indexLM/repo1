package com.lm.service.impl;


import com.lm.bean.Via;
import com.lm.dao.ViaMapper;
import com.lm.service.ViaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViaServiceImpl implements ViaService {
    @Autowired
    ViaMapper viaMapper;

    //按userid查询用户头像信息（via）
    @Override
    public Via getVia(int userid) {
        return viaMapper.selectByPrimaryKey(userid);
    }

    //上传用户头像（插入）（via）
    @Override
    public void setUserPhoto(Via via) {
        viaMapper.insert(via);
    }

    //按userid修改用户头像信息（via）
    @Override
    public void updateVia(Via via) {
        viaMapper.updateByPrimaryKey(via);
    }

    //删除用户对应的头像信息
    @Override
    public void deleteVia(Integer userid) {
        viaMapper.deleteByPrimaryKey(userid);
    }
}
