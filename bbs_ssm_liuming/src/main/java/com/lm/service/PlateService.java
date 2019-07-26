package com.lm.service;

import com.lm.bean.Plate;

import java.util.List;

public interface PlateService {
    List<Plate> getPlate();//查询板块信息（无条件）返回字符串
    String getPlateByRedis();//查询板块信息（无条件）
    void setPlate(Plate plate); //新增板块信息
    void deletePlate(Plate plate_delete);//按bid删除板块信息
    void updatePlate(Plate plate);//修改板块
    List<Plate> getPlateName(Plate plate);
}
