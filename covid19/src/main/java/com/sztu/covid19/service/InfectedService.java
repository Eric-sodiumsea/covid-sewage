package com.sztu.covid19.service;

import com.sztu.covid19.entity.Infected;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sztu.covid19.entity.InfectedResult;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author xnh
 * @since 2023-01-25
 */
public interface InfectedService extends IService<Infected> {

    List<InfectedResult> listDate(String beginDate, String endDate, Integer placeId);
}
