package com.sztu.covid19.service.impl;

import com.sztu.covid19.entity.Virus;
import com.sztu.covid19.entity.VirusResult;
import com.sztu.covid19.mapper.VirusMapper;
import com.sztu.covid19.service.VirusService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xnh
 * @since 2023-01-25
 */
@Service
public class VirusServiceImpl extends ServiceImpl<VirusMapper, Virus> implements VirusService {

    @Resource
    private VirusMapper virusMapper;

    @Override
    public List<VirusResult> listDate(String beginDate, String endDate, Integer placeId) {
        return virusMapper.listDate(beginDate, endDate, placeId);
    }
}
