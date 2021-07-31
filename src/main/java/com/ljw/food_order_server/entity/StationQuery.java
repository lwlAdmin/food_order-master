package com.ljw.food_order_server.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class StationQuery {


    private String location;


    private Integer floor;


    private String beginTime;


    private String endTime;

}
