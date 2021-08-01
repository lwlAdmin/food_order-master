package com.ljw.food_order_server.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljw.food_order_server.entity.R;
import com.ljw.food_order_server.entity.Station;
import com.ljw.food_order_server.entity.StationQuery;
import com.ljw.food_order_server.entity.StationUpdate;
import com.ljw.food_order_server.service.StationService;
import com.ljw.food_order_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private UserService userService;

    @PostMapping("pageStationCondition/{current}/{limit}")
    public R pageTeacherCondition(@PathVariable long current,
                                  @PathVariable long limit,
                                  @RequestBody(required = false) StationQuery stationQuery){
        //创建page对象
        Page<Station> stationPage= new Page<>(current,limit);
        //构建条件
        QueryWrapper<Station> wrapper= new QueryWrapper<>();
        // 多条件组合查询
        // mybatis学过 动态sql
        String location = stationQuery.getLocation();
        Integer floor = stationQuery.getFloor();
        String beginTime = stationQuery.getBeginTime();
        String endTime = stationQuery.getEndTime();
        //判断条件值是否为空，如果不为空拼接条件
        if(!StringUtils.isEmpty(location)) {
            //构建条件,前面带的是字段名
            wrapper.like("location",location); //名字，模糊查询
        }
        if(!StringUtils.isEmpty(floor)) {
            wrapper.eq("floor",floor); //楼层高度
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
    /**
     * 查询所有共享工位总数(包括已被预定的)
     * @return
     */
    @RequestMapping("/allCount")
    public R list() {
        int count = stationService.count();
        return R.ok().data("allTotal",count);
    }
    /**
     * 查询所有已被预定的共享工位总数
     * @return
     */
    @RequestMapping("/count")
    public R listByLocation (){
        QueryWrapper<Station> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("shared", 1);
        int count = stationService.count(queryWrapper);
        return R.ok().data("total",count);
    }

    /**
     * 查询员工预定的工位信息
     * @param userId
     * @return null代表此员工没有预定工位
     */
    @RequestMapping("/getStation/{userId}")
    public R getStation(@PathVariable Integer userId){
        QueryWrapper<Station> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        List<Station> list = stationService.list(queryWrapper);
        return R.ok().data("items",list);
    }

    /**
     * 员工预定工位
     * @param station
     */
    @RequestMapping("/confirmStation")
    public R confirmStation(@RequestBody Station station){
        UpdateWrapper<Station> stationUpdateWrapper = new UpdateWrapper<>();
        stationUpdateWrapper.eq("station_primary",station.getStationPrimary());
        stationService.update(station,stationUpdateWrapper);
        return R.ok();
    }

    /**
     * 员工取消工位
     * @param station
     * @return
     */
    @RequestMapping("/cancelStation")
    public R cancelStation(@RequestBody Station station){
       return confirmStation(station);
    }

}

