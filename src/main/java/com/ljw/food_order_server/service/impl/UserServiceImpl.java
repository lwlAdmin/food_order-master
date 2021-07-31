package com.ljw.food_order_server.service.impl;

import com.ljw.food_order_server.entity.User;
import com.ljw.food_order_server.mapper.UserMapper;
import com.ljw.food_order_server.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ljw
 * @since 2021-07-31
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
