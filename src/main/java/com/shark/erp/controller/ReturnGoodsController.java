package com.shark.erp.controller;

import com.alibaba.fastjson.JSONObject;
import com.shark.erp.entity.ReturnGoods;
import com.shark.erp.service.ReturnGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReturnGoodsController {
    @Autowired
    ReturnGoodsService returnGoodsService;

    @ResponseBody
    @GetMapping("/selectAllReturnGoods")
    public JSONObject selectAllReturnGoods() {
        return returnGoodsService.selectAllReturnGoods();
    }

    @ResponseBody
    @GetMapping("/selectReturnGoodsByCustomerId")
    public JSONObject selectReturnGoodsByCustomerId(@RequestParam("customerId") int customerId) {
        return returnGoodsService.selectReturnGoodsByCustomerId(customerId);
    }

    @ResponseBody
    @PostMapping("/insertReturnGoods") //获取前端传来的json参数
    public JSONObject insertReturnGoods(@RequestBody ReturnGoods returnGoods) {
        return returnGoodsService.insertReturnGoods(returnGoods);
    }

    @ResponseBody
    @DeleteMapping("/deleteReturnGoods")
    public JSONObject deleteReturnGoods(@RequestParam("id") int id) {
        return returnGoodsService.deleteReturnGoods(id);
    }

    @ResponseBody
    @PostMapping("/updateReturnGoods")
    public JSONObject updateReturnGoods(@RequestBody ReturnGoods returnGoods) {
        return returnGoodsService.updateReturnGoods(returnGoods);
    }

    /**
     * 区分该表单请求是添加还是修改
     */
    @PostMapping("/returnGoodsAction")
    public String returnGoodsAction(@RequestParam("action") String action) {
        if (action.equals("edit")) {
            return "forward:/updateReturnGoods";
        } else if (action.equals("add")) {
            return "forward:/insertReturnGoods";
        }
        return "404";
    }

    @ResponseBody
    @PutMapping("/passReturnGoodsById")
    public JSONObject passReturnGoodsById(@RequestParam("id") int id) {
        return returnGoodsService.passReturnGoodsById(id);
    }
}
