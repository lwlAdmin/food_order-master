package com.ljw.food_order_server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 饭小美多功能智慧用餐平台
 */
@SpringBootApplication
@MapperScan("com/ljw/food_order_server/mapper")
public class FoodOrderServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodOrderServerApplication.class, args);
    }

}
