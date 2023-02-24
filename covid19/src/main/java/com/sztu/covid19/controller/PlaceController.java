package com.sztu.covid19.controller;


import com.sztu.covid19.Common.Result;
import com.sztu.covid19.entity.PlaceRelation;
import com.sztu.covid19.entity.PlaceResult;
import com.sztu.covid19.entity.VirusResult;
import com.sztu.covid19.entity.VirusSimpleResult;
import com.sztu.covid19.service.PlaceService;
import com.sztu.covid19.service.VirusService;
import com.sztu.covid19.service.impl.VirusServiceImpl;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
    private VirusService virusService;

    // 查询所有（大范围）地点名称
    @GetMapping("/listName")
    public Result listName() {

        return Result.suc(placeService.listName());
    }

    // 查询所有（小范围）地点名称
    @GetMapping("/listNameDetail")
    public Result listNameDetail(@RequestParam("fatherId") Integer fatherId) {

        return Result.suc(placeService.listNameDetail(fatherId));
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

        // 获取一个月前的日期
        Calendar endDate1 = Calendar.getInstance();
        Date endDate2 = sdf.parse(endDate);
        endDate1.setTime(endDate2);
        endDate1.add(Calendar.MONTH, -1);
        endDate1.add(Calendar.DAY_OF_YEAR, 1);
        Date endDate3 = endDate1.getTime();
        beginDate = sdf.format(endDate3);

        // 得到（大范围）所有建筑
        List<PlaceResult> result = placeService.listMonth(beginDate, endDate);

        // 得到每个建筑最近一个月内各天的总CT值
        for (PlaceResult placeResult : result) {
            List<VirusResult> virusResultMonthList = virusService.listDate(beginDate, endDate, placeResult.getId());

            List<VirusSimpleResult> virusSimpleResultList = new ArrayList<>();
            for (VirusResult virusResult : virusResultMonthList) {
                VirusSimpleResult virusSimpleResult = new VirusSimpleResult();
                virusSimpleResult.setDate(virusResult.getDate());
                virusSimpleResult.setTotalCT(virusResult.getTotalCT());
                virusSimpleResultList.add(virusSimpleResult);
            }

            placeResult.setMonthList(virusSimpleResultList);
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

        // 获取一个月前的日期
        Calendar endDate1 = Calendar.getInstance();
        Date endDate2 = sdf.parse(endDate);
        endDate1.setTime(endDate2);
        endDate1.add(Calendar.MONTH, -1);
        endDate1.add(Calendar.DAY_OF_YEAR, 1);
        Date endDate3 = endDate1.getTime();
        beginDate = sdf.format(endDate3);

        // 得到（小范围）所有建筑
        List<PlaceResult> result = placeService.listMonthDetail(fatherId, beginDate, endDate);

        // 得到每个建筑最近一个月内各天的总CT值
        for (PlaceResult placeResult : result) {
            List<VirusResult> virusResultMonthList = virusService.listDate(beginDate, endDate, placeResult.getId());

            List<VirusSimpleResult> virusSimpleResultList = new ArrayList<>();
            for (VirusResult virusResult : virusResultMonthList) {
                VirusSimpleResult virusSimpleResult = new VirusSimpleResult();
                virusSimpleResult.setDate(virusResult.getDate());
                virusSimpleResult.setTotalCT(virusResult.getTotalCT());
                virusSimpleResultList.add(virusSimpleResult);
            }

            placeResult.setMonthList(virusSimpleResultList);
        }

        return Result.suc(result);
    }
}
