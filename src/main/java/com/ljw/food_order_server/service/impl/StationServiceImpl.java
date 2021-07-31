package com.ljw.food_order_server.service.impl;

import com.ljw.food_order_server.entity.Station;
import com.ljw.food_order_server.mapper.StationMapper;
import com.ljw.food_order_server.service.StationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ljw
 * @since 2021-07-31
 */
@Service
public class StationServiceImpl extends ServiceImpl<StationMapper, Station> implements StationService {
    @Autowired
    private StationMapper stationmapper;

    /**
     * 查询全部共享工位
     * @return 全部工位
     */
    @Override
    public List<Station> list() {
        return stationmapper.selectList(null);
    }
}
