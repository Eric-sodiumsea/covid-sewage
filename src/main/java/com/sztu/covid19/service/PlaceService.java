package com.sztu.covid19.service;

import com.sztu.covid19.entity.InfectedResult;
import com.sztu.covid19.entity.Place;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sztu.covid19.entity.PlaceResult;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xnh
 * @since 2023-02-08
 */
public interface PlaceService extends IService<Place> {

    // 查询所有地点名称
    List<Place> listName();

    // 查询（大范围）地点的经纬度
    List<Place> listPos();

    // 查询（小范围）地点的经纬度
    List<Place> listPosDetail(Integer fatherId);

    // 获取（大范围）所有建筑最近一个月的污水载量
    List<PlaceResult> listMonth(String beginDate, String endDate);

    // 获取（小范围）所有建筑最近一个月的污水载量
    List<PlaceResult> listMonthDetail(Integer fatherId, String beginDate, String endDate);
}
