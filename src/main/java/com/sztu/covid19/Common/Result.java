package com.sztu.covid19.Common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.text.DecimalFormat;

@Data
public class Result {

    private int code;    // 编码 200/400
    private String msg;  // 成功/失败
    private Double totalDouble;  // 总记录数（浮点数）
    private Integer totalInteger;  // 总记录数（整数）
    private Double aver; // 近7天平均数（浮点数）
    private String latestDate; // 所有点位中最晚的日期
    private Object data; // 数据

    public static Result fail() {
        return result(400, "失败", 0.0, 0.0, "0000-00-00", null);
    }

    public static Result suc() {
        return result(200, "成功", 0.0, 0.0, "0000-00-00", null);
    }

    public static Result suc(Object data) {
        return result(200, "成功", 0.0, 0.0, "0000-00-00", data);
    }

    public static Result suc(Object data, Double total) {
        return result(200, "成功", total, 0.0, "0000-00-00", data);
    }

    public static Result suc(Object data, Double total, Double aver) {
        return result(200, "成功", total, aver, "0000-00-00", data);
    }

    public static Result suc(Object data, String latestDate) {
        return result(200, "成功", 0.0, 0.0, latestDate, data);
    }

    private static Result result(int code, String msg, Double total, Double aver, String latestDate, Object data) {
        Result res = new Result();
        res.setCode(code);
        res.setMsg(msg);
        res.setData(data);
        // totalInterger四舍五入取整
        res.setTotalInteger((int) Math.round(total));
        // totalDouble保留两位小数
        DecimalFormat df1 = new DecimalFormat("#.00");
        String dfFormat = df1.format(total);
        total = Double.parseDouble(dfFormat);
        res.setTotalDouble(total);
        // aver保留两位小数
        DecimalFormat df2 = new DecimalFormat("#.00");
        String averFormat = df2.format(aver);
        aver = Double.parseDouble(averFormat);
        res.setAver(aver);
        // 所有点位中最晚的日期
        res.setLatestDate(latestDate);
        return res;
    }
}
