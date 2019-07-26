package com.lm.dao;

import com.lm.bean.Plate;

import java.util.List;

public interface PlateMapper {
    //按bid删除板块信息
    int deleteByPrimaryKey(Integer bid);
    //板块插入
    int insert(Plate record);

    //查询板块的所有信息
    List<Plate> selectAll();

    //按板块名查询
    List<Plate> selectByAdminName(Plate plate);

    //修改板块
    int updateByPrimaryKey(Plate record);
}
