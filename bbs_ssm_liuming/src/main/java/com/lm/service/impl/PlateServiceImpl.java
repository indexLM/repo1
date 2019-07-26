package com.lm.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lm.bean.Plate;
import com.lm.dao.PlateMapper;
import com.lm.service.PlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.List;

@Service
public class PlateServiceImpl implements PlateService {
    @Autowired
    PlateMapper plateMapper;

    //查询板块信息（无条件）
    @Override
    public List<Plate> getPlate() {
        return plateMapper.selectAll();
    }

    //查询板块信息（无条件）返回字符串
    @Override
    public String getPlateByRedis() {
        Jedis jedis = new Jedis();
        String jsonPlates = null;
        ObjectMapper om = new ObjectMapper();
        try {
            jsonPlates = jedis.get("plates");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (jsonPlates == null || "".equals(jsonPlates)) {
            List<Plate> plates = plateMapper.selectAll();
            try {
                jsonPlates = om.writeValueAsString(plates);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            jedis.set("plates",jsonPlates);
            System.out.println("请求的数据库");
        }else {
            System.out.println("请求的redis");
        }
        return jsonPlates;
    }

    //新增板块信息
    @Override
    public void setPlate(Plate plate) {
        plateMapper.insert(plate);
    }

    //按bid删除板块信息
    @Override
    public void deletePlate(Plate plate_delete) {
        plateMapper.deleteByPrimaryKey(plate_delete.getBid());
    }

    //修改板块
    @Override
    public void updatePlate(Plate plate) {
        plateMapper.updateByPrimaryKey(plate);
    }

    @Override
    public List<Plate> getPlateName(Plate plate) {
        return plateMapper.selectByAdminName(plate);
    }
}
