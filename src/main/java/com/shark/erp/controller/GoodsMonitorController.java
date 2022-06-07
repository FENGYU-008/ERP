package com.shark.erp.controller;

import com.alibaba.fastjson.JSONObject;
import com.shark.erp.service.GoodsMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GoodsMonitorController {
    @Autowired
    GoodsMonitorService goodsMonitorService;

    @ResponseBody
    @GetMapping("/selectAllGoodsMonitor")
    public JSONObject selectAllGoodsMonitor() {
        return goodsMonitorService.selectAllGoodsMonitor();
    }
}
