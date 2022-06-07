package com.shark.erp.mapper;

import com.shark.erp.entity.GoodsMonitor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMonitorMapper {
    List<GoodsMonitor> selectAllGoodsMonitor();
}
