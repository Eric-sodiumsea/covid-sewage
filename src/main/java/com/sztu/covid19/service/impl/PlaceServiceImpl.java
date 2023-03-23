package com.sztu.covid19.service.impl;

import com.sztu.covid19.entity.InfectedResult;
import com.sztu.covid19.entity.Place;
import com.sztu.covid19.entity.PlaceResult;
import com.sztu.covid19.mapper.InfectedMapper;
import com.sztu.covid19.mapper.PlaceMapper;
import com.sztu.covid19.service.PlaceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xnh
 * @since 2023-02-08
 */
@Service
public class PlaceServiceImpl extends ServiceImpl<PlaceMapper, Place> implements PlaceService {

    @Resource
    private PlaceMapper placeMapper;

    @Override
    // 查询（大范围）地点的经纬度
    public List<Place> listPos() {

        return placeMapper.listPos();
    }

    @Override
    // 查询（小范围）地点的经纬度
    public List<Place> listPosDetail(Integer fatherId) {

        return placeMapper.listPosDetail(fatherId);
    }

    @Override
    // 获取（大范围）所有建筑最近一个月的污水载量
    public List<PlaceResult> listMonth(String beginDate, String endDate) {

        return placeMapper.listMonth(beginDate, endDate);
    }

    @Override
    // 获取（小范围）所有建筑最近一个月的污水载量
    public List<PlaceResult> listMonthDetail(Integer fatherId, String beginDate, String endDate) {

        return placeMapper.listMonthDetail(fatherId, beginDate, endDate);
    }
}
