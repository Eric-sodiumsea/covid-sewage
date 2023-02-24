package com.sztu.covid19.mapper;

import com.sztu.covid19.entity.Place;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sztu.covid19.entity.PlaceResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xnh
 * @since 2023-02-08
 */
@Mapper
public interface PlaceMapper extends BaseMapper<Place> {

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
