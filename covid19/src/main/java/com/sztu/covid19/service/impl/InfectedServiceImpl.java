package com.sztu.covid19.service.impl;

import com.sztu.covid19.entity.Infected;
import com.sztu.covid19.entity.InfectedResult;
import com.sztu.covid19.mapper.InfectedMapper;
import com.sztu.covid19.service.InfectedService;
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
public class InfectedServiceImpl extends ServiceImpl<InfectedMapper, Infected> implements InfectedService {

    @Resource
    private InfectedMapper infectedMapper;

    @Override
    public List<InfectedResult> listDate(String beginDate, String endDate, Integer placeId) {

        return infectedMapper.listDate(beginDate, endDate, placeId);
    }
}
