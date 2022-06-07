package com.shark.erp.service;

import com.alibaba.fastjson.JSONObject;
import com.shark.erp.entity.GoodsMonitor;
import com.shark.erp.mapper.GoodsMonitorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsMonitorService {
    @Autowired
    GoodsMonitorMapper goodsMonitorMapper;

    /**
     * 不想写sql语句也不想写JavaScript，所以把逻辑直接写死在程序里
     * TODO 烦死了
     *
     * @return result 返回table默认规定的数据格式
     */
    public JSONObject selectAllGoodsMonitor() {
        JSONObject result = new JSONObject();
        List<GoodsMonitor> goodsMonitors = goodsMonitorMapper.selectAllGoodsMonitor();
        result.put("code", 0);
        result.put("msg", "查询成功");
        result.put("count", goodsMonitors.size());
        result.put("data", goodsMonitors);
        return result;
    }
}
