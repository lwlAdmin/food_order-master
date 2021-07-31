package com.ljw.food_order_server.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ljw.food_order_server.entity.Station;
import com.ljw.food_order_server.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     * 查询所有工位的方法
     * @return
     */
    @RequestMapping("/list")
    public String list() {
        List<Station> list = stationService.list();
        String s = JSON.toJSONString(list);
        return s;
    }

    /**
     * 根据位置查询共享工位
     * @param location 共享工位位置
     * @return
     */
    @RequestMapping("/location/{location}")
    public String listByLocation(@PathVariable String location) {
        QueryWrapper<Station> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("location",location);
        List<Station> list = stationService.list(queryWrapper);
        String s = JSON.toJSONString(list);
        return s;
    }

}

