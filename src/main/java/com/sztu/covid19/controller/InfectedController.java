package com.sztu.covid19.controller;


import com.sztu.covid19.Common.Result;
import com.sztu.covid19.entity.InfectedResult;
import com.sztu.covid19.service.InfectedService;
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
@RequestMapping("/infected")
@CrossOrigin // 后加的 用来处理跨域
public class InfectedController {

    @Resource
    private InfectedService infectedService;

    // 根据日期范围查询
    @GetMapping("/listDate")
    public Result listDate(@RequestParam(value = "beginDate", defaultValue = "null") String beginDate, @RequestParam(value = "endDate", defaultValue = "null") String endDate, @RequestParam("placeId") Integer placeId/*place_detail_id*/) throws ParseException {

        // 格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // 处理日期
        if (beginDate.equals("null")) {
            beginDate = "0001-01-01";
        }
        if (endDate.equals("null")) {
            Calendar today = Calendar.getInstance();
            endDate = sdf.format(today.getTime());
        }


        // 得到时间段内各天的总感染人数
        List<InfectedResult> result = infectedService.listDate(beginDate, endDate, placeId);

        // 时间段内的总感染人数
        Double total = 0.0;
        for (InfectedResult infectedResult : result) {
            total += infectedResult.getTotal();
        }

        // 获取7天前的日期
        Calendar endDate1 = Calendar.getInstance();
        Date endDate2 = sdf.parse(endDate);
        endDate1.setTime(endDate2);
        endDate1.add(Calendar.DAY_OF_YEAR, -7);
        Date endDate3 = endDate1.getTime();
        String last7Day = sdf.format(endDate3);

        // 得到过去7天内各天的总感染人数
        List<InfectedResult> result7Days = infectedService.listDate(last7Day, endDate, placeId);
        System.out.println("过去7天内各天的总感染人数：" + result7Days);

        // 过去7天内的总感染人数
        Double total7 = 0.0;
        for (InfectedResult infectedResult : result7Days) {
            total7 += infectedResult.getTotal();
        }
        Double aver = 1.0 * total7 / 7.0;

        return Result.suc(result, total, aver);
    }

}
