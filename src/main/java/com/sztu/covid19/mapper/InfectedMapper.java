package com.sztu.covid19.mapper;

import com.sztu.covid19.entity.Infected;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sztu.covid19.entity.InfectedResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author xnh
 * @since 2023-01-25
 */
@Mapper
public interface InfectedMapper extends BaseMapper<Infected> {

    List<InfectedResult> listDate(String beginDate, String endDate, Integer placeId);
}
