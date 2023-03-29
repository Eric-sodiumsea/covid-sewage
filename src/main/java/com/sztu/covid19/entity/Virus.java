package com.sztu.covid19.entity;

import com.baomidou.mybatisplus.annotation.IdType;

import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.TableField;
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
 * @author xnh
 * @since 2023-01-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Virus对象", description = "")
public class Virus implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String date;

    @ApiModelProperty(value = "CT值")
    private Integer quantity;

    @ApiModelProperty(value = "对应的地点的id")
    private Integer placeDetailId;

    @ApiModelProperty("某天")
    @TableField(exist = false, select = false)
    private Double total;

    @ApiModelProperty("开始时间")
    @TableField(exist = false, select = false)
    private String beginDate;

    @ApiModelProperty("截止时间")
    @TableField(exist = false, select = false)
    private String endDate;

}
