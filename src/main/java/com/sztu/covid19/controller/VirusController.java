package com.sztu.covid19.controller;

import com.sztu.covid19.Common.Result;
import com.sztu.covid19.entity.Virus;
import com.sztu.covid19.entity.VirusResult;
import com.sztu.covid19.service.VirusService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xnh
 * @since 2023-01-25
 */
@RestController
@RequestMapping("/virus")
@CrossOrigin // 后加的 用来处理跨域
public class VirusController {

    @Resource
    private VirusService virusService;

    // 查询所有
    @GetMapping("/list")
    public Result list() {

        return Result.suc(virusService.list());
    }

    // 根据日期范围查询
    @GetMapping("/listDate")  // listD = list + Date
    public Result listDate(@RequestParam(value = "beginDate", defaultValue = "null") String beginDate, @RequestParam(value = "endDate", defaultValue = "null") String endDate, @RequestParam("placeId") Integer placeId/*place_detail_id*/) throws ParseException {

        // 格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // 处理日期
        if (beginDate.equals("null")) {
            beginDate = "0001-01-01";
        }
        if (endDate.equals("null")) {
            // 今天
            Calendar today = Calendar.getInstance();
            endDate = sdf.format(today.getTime());
        }

        // 得到时间段内各天的总CT值
        List<VirusResult> result = virusService.listDate(beginDate, endDate, placeId);

        // 时间段内的总CT值
        Double totalCT = 0.0;
        for (VirusResult virusResult : result) {
            totalCT += virusResult.getTotalCT();
        }

        // 获取7天前的日期
        Calendar endDate1 = Calendar.getInstance();
        Date endDate2 = sdf.parse(endDate);
        endDate1.setTime(endDate2);
        endDate1.add(Calendar.DAY_OF_YEAR, -7);
        Date endDate3 = endDate1.getTime();
        String last7Day = sdf.format(endDate3);

        // 得到过去7天内各天的总CT值
        List<VirusResult> result7Days = virusService.listDate(last7Day, endDate, placeId);
        System.out.println("过去7天内各天的总CT值：" + result7Days);

        // 过去7天内的总CT值
        Double totalCT7 = 0.0;
        for (VirusResult virusResult : result7Days) {
            totalCT7 += virusResult.getTotalCT();
        }
        Double aver = 1.0 * totalCT7 / 7.0;

        return Result.suc(result, totalCT, aver);
    }

}
