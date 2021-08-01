package com.ljw.food_order_server.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.Mapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ljw.food_order_server.entity.User;
import com.ljw.food_order_server.mapper.UserMapper;
import com.ljw.food_order_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ljw
 * @since 2021-07-31
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询员工预定的共享工位信息
     * @param userId 员工编号
     * @return
     */
    @RequestMapping("/getStation/{userId}")
    public String getStation(@PathVariable String userId){
        QueryWrapper<User> query = Wrappers.query();
        query.select("station_primary").eq("user_id",userId);
        User user = userService.getOne(query);
        if (user.getStationPrimary() == -1){
            return "";
        }
        return JSON.toJSONString(userService.list(query));
    }

}

