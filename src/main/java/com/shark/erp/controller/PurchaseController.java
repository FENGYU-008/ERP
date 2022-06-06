package com.shark.erp.controller;

import com.alibaba.fastjson.JSONObject;
import com.shark.erp.entity.Purchase;
import com.shark.erp.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PurchaseController {
    @Autowired
    PurchaseService purchaseService;

    @ResponseBody
    @GetMapping("/selectAllPurchase")
    public JSONObject selectAllPurchase() {
        return purchaseService.selectAllPurchase();
    }

    @ResponseBody
    @GetMapping("/selectPurchaseBySupplier")
    public JSONObject selectPurchaseBySupplier(@RequestParam("supplier") String supplier) {
        return purchaseService.selectPurchaseBySupplier(supplier);
    }

    @ResponseBody
    @PostMapping("/insertPurchase") //获取前端传来的json参数
    public JSONObject insertPurchase(@RequestBody Purchase purchase) {
        return purchaseService.insertPurchase(purchase);
    }

    @ResponseBody
    @DeleteMapping("/deletePurchase")
    public JSONObject deletePurchase(@RequestParam("id") int id) {
        return purchaseService.deletePurchase(id);
    }

    @ResponseBody
    @PostMapping("/updatePurchase")
    public JSONObject updatePurchase(@RequestBody Purchase purchase) {
        return purchaseService.updatePurchase(purchase);
    }

    /**
     * 区分该表单请求是添加还是修改
     */
    @PostMapping("/purchaseAction")
    public String purchaseAction(@RequestParam("action") String action) {
        if (action.equals("edit")) {
            return "forward:/updatePurchase";
        } else if (action.equals("add")) {
            return "forward:/insertPurchase";
        }
        return "404";
    }
}
