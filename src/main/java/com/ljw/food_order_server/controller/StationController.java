package com.ljw.food_order_server.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ljw.food_order_server.entity.R;
import com.ljw.food_order_server.entity.Station;
import com.ljw.food_order_server.entity.StationMapper;
import com.ljw.food_order_server.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ljw
 * @since 2021-07-31
 */
@RestController
@RequestMapping("/station")
public class StationController {

    @Autowired
    private StationService stationService;

    @PostMapping("pageStationCondition/{current}/{limit}")
    public R pageTeacherCondition(@PathVariable long current,
                                  @PathVariable long limit,
                                  @RequestBody(required = false) StationMapper stationMapper){
        //创建page对象
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Station> stationPage=
                new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(current,limit);
        //构建条件
        QueryWrapper<Station> wrapper= new QueryWrapper<>();
        // 多条件组合查询
        // mybatis学过 动态sql
        String location = stationMapper.getLocation();
        Integer floor = stationMapper.getFloor();
        String beginTime = stationMapper.getBeginTime();
        String endTime = stationMapper.getEndTime();
        //判断条件值是否为空，如果不为空拼接条件
        if(!StringUtils.isEmpty(location)) {
            //构建条件,前面带的是字段名
            wrapper.like("location",location); //名字，模糊查询
        }
        if(!StringUtils.isEmpty(floor)) {
            wrapper.eq("floor",floor); //等级
        }
        if(!StringUtils.isEmpty(beginTime)) {
            wrapper.ge("beginTime",beginTime); //开始时间
        }
        if(!StringUtils.isEmpty(endTime)) {
            wrapper.le("endTime",endTime);//结束时间
        }
        stationService.page( stationPage,wrapper);
        long total =stationPage.getTotal();//总记录数
        List<Station> records=stationPage.getRecords(); //数据list集合
        return R.ok().data("total",total).data("items",records);

    }
}

