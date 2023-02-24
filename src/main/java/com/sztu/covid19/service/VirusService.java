package com.sztu.covid19.service;

import com.sztu.covid19.entity.Virus;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sztu.covid19.entity.VirusResult;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author xnh
 * @since 2023-01-25
 */
public interface VirusService extends IService<Virus> {

    List<VirusResult> listDate(String beginDate, String endDate, Integer placeId);
}
