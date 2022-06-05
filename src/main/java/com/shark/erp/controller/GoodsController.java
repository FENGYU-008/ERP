package com.shark.erp.controller;

import com.alibaba.fastjson.JSONObject;
import com.shark.erp.entity.Goods;
import com.shark.erp.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @ResponseBody
    @GetMapping("/selectAllGoods")
    public JSONObject selectAllGoods() {
        return goodsService.selectAllGoods();
    }

    @ResponseBody
    @GetMapping("/selectGoodsByName")
    public JSONObject selectGoodsByName(@RequestParam("name") String name) {
        return goodsService.selectGoodsByName(name);
    }

    @ResponseBody
    @PostMapping("/insertGoods") //获取前端传来的json参数
    public JSONObject insertGoods(@RequestBody Goods goods) {
        return goodsService.insertGoods(goods);
    }

    @ResponseBody
    @DeleteMapping("/deleteGoods")
    public JSONObject deleteGoods(@RequestParam("id") int id) {
        return goodsService.deleteGoods(id);
    }

    @ResponseBody
    @PostMapping("/updateGoods")
    public JSONObject updateGoods(@RequestBody Goods goods) {
        return goodsService.updateGoods(goods);
    }

    /**
     * 区分该表单请求是添加还是修改
     */
    @PostMapping("/goodsAction")
    public String goodsAction(@RequestParam("action") String action) {
        if (action.equals("edit")) {
            return "forward:/updateGoods";
        } else if (action.equals("add")) {
            return "forward:/insertGoods";
        }
        return "404";
    }

    @ResponseBody
    @GetMapping("/selectDistinctCategory")
    public JSONObject selectDistinctCategory() {
        return goodsService.selectDistinctCategory();
    }

    @ResponseBody
    @GetMapping("/selectGoodsByNameAndCategory")
    public JSONObject selectGoodsByNameAndCategory(@RequestParam("name") String name, @RequestParam("category") String category) {
        return goodsService.selectGoodsByNameAndCategory(name, category);
    }
}
