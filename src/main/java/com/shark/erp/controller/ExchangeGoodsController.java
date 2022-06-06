package com.shark.erp.controller;

import com.alibaba.fastjson.JSONObject;
import com.shark.erp.entity.ExchangeGoods;
import com.shark.erp.service.ExchangeGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ExchangeGoodsController {
    @Autowired
    ExchangeGoodsService exchangeGoodsService;

    @ResponseBody
    @GetMapping("/selectAllExchangeGoods")
    public JSONObject selectAllExchangeGoods() {
        return exchangeGoodsService.selectAllExchangeGoods();
    }

    @ResponseBody
    @GetMapping("/selectExchangeGoodsByCustomerId")
    public JSONObject selectExchangeGoodsByCustomerId(@RequestParam("customerId") int customerId) {
        return exchangeGoodsService.selectExchangeGoodsByCustomerId(customerId);
    }

    @ResponseBody
    @PostMapping("/insertExchangeGoods") //获取前端传来的json参数
    public JSONObject insertExchangeGoods(@RequestBody ExchangeGoods exchangeGoods) {
        return exchangeGoodsService.insertExchangeGoods(exchangeGoods);
    }

    @ResponseBody
    @DeleteMapping("/deleteExchangeGoods")
    public JSONObject deleteExchangeGoods(@RequestParam("id") int id) {
        return exchangeGoodsService.deleteExchangeGoods(id);
    }

    @ResponseBody
    @PostMapping("/updateExchangeGoods")
    public JSONObject updateExchangeGoods(@RequestBody ExchangeGoods exchangeGoods) {
        return exchangeGoodsService.updateExchangeGoods(exchangeGoods);
    }

    /**
     * 区分该表单请求是添加还是修改
     */
    @PostMapping("/exchangeGoodsAction")
    public String exchangeGoodsAction(@RequestParam("action") String action) {
        if (action.equals("edit")) {
            return "forward:/updateExchangeGoods";
        } else if (action.equals("add")) {
            return "forward:/insertExchangeGoods";
        }
        return "404";
    }

    @ResponseBody
    @PutMapping("/passExchangeGoodsById")
    public JSONObject passExchangeGoodsById(@RequestParam("id") int id) {
        return exchangeGoodsService.passExchangeGoodsById(id);
    }
}
