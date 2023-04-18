package com.sztu.covid19.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sztu.covid19.Common.Result;
import com.sztu.covid19.entity.*;
import com.sztu.covid19.service.PlaceDetailService;
import com.sztu.covid19.service.PlaceService;
import com.sztu.covid19.service.VirusService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xnh
 * @since 2023-02-08
 */
@RestController
@RequestMapping("/place")
@CrossOrigin // 后加的 用来处理跨域
public class PlaceController {

    @Resource
    private PlaceService placeService;
    @Resource
    private PlaceDetailService placeDetailService;
    @Resource
    private VirusService virusService;

    // 查询所有地点名称
    @GetMapping("/listName")
    public List<PlaceNameResult> listName1() {

        List<PlaceNameResult> placeNameResultList = new ArrayList<>();

        QueryWrapper<Place> wrapper = new QueryWrapper<>();
        wrapper.select("id", "place_name");
        List<Place> placeList = placeService.list(wrapper);

        for (Place place : placeList) {

            QueryWrapper<PlaceDetail> wrapperDetail = new QueryWrapper<>();
            wrapperDetail.select("id", "place_name");
            wrapperDetail.eq("father_id", place.getId());
            List<PlaceDetail> placeDetailList = placeDetailService.list(wrapperDetail);

            PlaceNameResult placeNameResult = new PlaceNameResult();

            placeNameResult.setId(place.getId());
            placeNameResult.setPlaceName(place.getPlaceName());
            placeNameResult.setPlaceDetail(placeDetailList);

            placeNameResultList.add(placeNameResult);
        }

        return placeNameResultList;
    }

    // 查询（大范围）地点的经纬度
    @GetMapping("/listPos")
    public Result listPosFather() {

        return Result.suc(placeService.listPos());
    }

    // 查询（小范围）地点的经纬度
    @GetMapping("/listPosDetail")
    public Result listPosChild(@RequestParam("fatherId") Integer fatherId) {

        return Result.suc(placeService.listPosDetail(fatherId));
    }

    // 获取（大范围）所有建筑最近一个月的CT值
    @GetMapping("/listMonth")
    public Result listMonth() throws ParseException {

        // 格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // 最近一个月
        String beginDate;
        String endDate;

        // 获取今天的日期
        Calendar today = Calendar.getInstance();
        endDate = sdf.format(today.getTime());

        // 获取一个月前的日期（beginDate = endDate - 1month）
        Calendar beginDate1 = Calendar.getInstance();
        Date beginDate2 = sdf.parse(endDate);
        beginDate1.setTime(beginDate2);
        beginDate1.add(Calendar.MONTH, -1);
        beginDate1.add(Calendar.DAY_OF_YEAR, 1);
        Date beginDate3 = beginDate1.getTime();
        beginDate = sdf.format(beginDate3);

        // 得到（大范围）所有建筑
        List<PlaceResult> result = placeService.listMonth();

        // 得到每个建筑最近一个月内各天的总CT值
        for (PlaceResult placeResult : result) {
            List<VirusResult> virusResultMonthList = virusService.listDate(beginDate, endDate, placeResult.getId());
            placeResult.setMonthList(virusResultMonthList);
        }

        return Result.suc(result);
    }

    // 获取（小范围）所有建筑最近一个月的CT值
    @GetMapping("/listMonthDetail")
    public Result listMonthDetail(@RequestParam("fatherId") Integer fatherId) throws ParseException {

        // 格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // 最近一个月
        String beginDate;
        String endDate;

        // 获取今天的日期
        Calendar today = Calendar.getInstance();
        endDate = sdf.format(today.getTime());

        // 获取一个月前的日期（beginDate = endDate - 1month）
        Calendar beginDate1 = Calendar.getInstance();
        Date beginDate2 = sdf.parse(endDate);
        beginDate1.setTime(beginDate2);
        beginDate1.add(Calendar.MONTH, -1);
        beginDate1.add(Calendar.DAY_OF_YEAR, 1);
        Date beginDate3 = beginDate1.getTime();
        beginDate = sdf.format(beginDate3);

        // 得到（小范围）所有建筑
        List<PlaceResult> result = placeService.listMonthDetail(fatherId);

        // 得到每个建筑最近一个月内各天的总CT值
        for (PlaceResult placeResult : result) {
            List<VirusResult> virusResultMonthList = virusService.listDate(beginDate, endDate, placeResult.getId());
            placeResult.setMonthList(virusResultMonthList);
        }

        return Result.suc(result);
    }

    // 获取（大范围）所有建筑的最近日期的最近一个月的CT值
    @GetMapping("/listMonth1")
    public Result listMonth1() throws ParseException {

        // 得到（大范围）所有建筑
        List<PlaceResult> result = placeService.listMonth();

        // 格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // 最近一个月
        String beginDate;
        String endDate = "0000-00-00";

        for (PlaceResult placeResult : result) {
            // 获取最近的日期
            QueryWrapper<Virus> wrapper = new QueryWrapper<>();
            wrapper.isNotNull("ct1");
            wrapper.eq("place_detail_id", placeResult.getId());
            wrapper.select("max(date) as endDate");
            Map<String, Object> map = virusService.getMap(wrapper);
            if (map != null && map.get("endDate").toString().compareTo(endDate) > 0) {
                endDate = map.get("endDate").toString();
            }
        }

        if (endDate == "0000-00-00") {
            // 如果该place_detail没有数据，则直接令endDate等于今天
            Calendar today = Calendar.getInstance();
            endDate = sdf.format(today.getTime());
        }

        // 获取一个月前的日期（beginDate = endDate - 1month）
        Calendar beginDate1 = Calendar.getInstance();
        Date beginDate2 = sdf.parse(endDate);
        beginDate1.setTime(beginDate2);
        beginDate1.add(Calendar.MONTH, -1);
        beginDate1.add(Calendar.DAY_OF_YEAR, 1);
        Date beginDate3 = beginDate1.getTime();
        beginDate = sdf.format(beginDate3);

        // 所有点位中最晚的日期
        String latestDate = "0000-00-00";

        // 得到每个建筑最近一个月内各天的总CT值
        for (PlaceResult placeResult : result) {
            List<VirusResult> virusResultMonthList = virusService.listDate(beginDate, endDate, placeResult.getId());
            if (virusResultMonthList.size() != 0 && virusResultMonthList.get(virusResultMonthList.size()-1).getDate().compareTo(latestDate) > 0) {
                latestDate = virusResultMonthList.get(virusResultMonthList.size()-1).getDate();
            }
            placeResult.setMonthList(virusResultMonthList);
        }

        return Result.suc(result, latestDate);
    }

    // 获取（小范围）所有建筑的最近日期的最近一个月的CT值
    @GetMapping("/listMonthDetail1")
    public Result listMonthDetail1(@RequestParam("fatherId") Integer fatherId) throws ParseException {

        // 得到（小范围）所有建筑
        List<PlaceResult> result = placeService.listMonthDetail(fatherId);

        // 格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // 最近一个月
        String beginDate;
        String endDate = "0000-00-00";

        for (PlaceResult placeResult : result) {
            // 获取最近的日期
            QueryWrapper<Virus> wrapper = new QueryWrapper<>();
            wrapper.isNotNull("ct1");
            wrapper.eq("place_detail_id", placeResult.getId());
            wrapper.select("max(date) as endDate");
            Map<String, Object> map = virusService.getMap(wrapper);
            if (map != null && map.get("endDate").toString().compareTo(endDate) > 0) {
                endDate = map.get("endDate").toString();
            }
        }

        if (endDate == "0000-00-00") {
            // 如果该place_detail没有数据，则直接令endDate等于今天
            Calendar today = Calendar.getInstance();
            endDate = sdf.format(today.getTime());
        }

        // 获取一个月前的日期（beginDate = endDate - 1month）
        Calendar beginDate1 = Calendar.getInstance();
        Date beginDate2 = sdf.parse(endDate);
        beginDate1.setTime(beginDate2);
        beginDate1.add(Calendar.MONTH, -1);
        beginDate1.add(Calendar.DAY_OF_YEAR, 1);
        Date beginDate3 = beginDate1.getTime();
        beginDate = sdf.format(beginDate3);

        // 所有点位中最晚的日期
        String latestDate = "0000-00-00";

        // 得到每个建筑最近一个月内各天的总CT值
        for (PlaceResult placeResult : result) {
            List<VirusResult> virusResultMonthList = virusService.listDate(beginDate, endDate, placeResult.getId());
            if (virusResultMonthList.size() != 0 && virusResultMonthList.get(virusResultMonthList.size()-1).getDate().compareTo(latestDate) > 0) {
                latestDate = virusResultMonthList.get(virusResultMonthList.size()-1).getDate();
            }
            placeResult.setMonthList(virusResultMonthList);
        }

        return Result.suc(result, latestDate);
    }
}
