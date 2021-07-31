package com.ljw.food_order_server.controller;


import com.alibaba.fastjson.JSON;
import com.ljw.food_order_server.entity.Station;
import com.ljw.food_order_server.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/list")
    public String list() {
        String s = JSON.toJSONString(stationService.list());
        return s;
    }
}

