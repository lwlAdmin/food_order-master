package com.ljw.food_order_server.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author ljw
 * @since 2021-07-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("station")
@ApiModel(value="Station对象", description="")
public class Station implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "station_primary", type = IdType.AUTO)
    private Integer stationPrimary;

    private String stationId;

    private String location;

    private Integer floor;

    private Date startTime;

    private Date endTime;

    private Integer shared;

    private Integer userId;


}
