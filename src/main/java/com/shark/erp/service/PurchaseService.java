package com.shark.erp.service;

import com.alibaba.fastjson.JSONObject;
import com.shark.erp.entity.Purchase;
import com.shark.erp.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {
    @Autowired
    PurchaseMapper purchaseMapper;

    public JSONObject selectAllPurchase() {
        JSONObject result = new JSONObject();
        try {
            List<Purchase> purchaseList = purchaseMapper.selectAllPurchase();
            result.put("code", 0);
            result.put("msg", "查询成功");
            result.put("count", purchaseList.size());
            result.put("data", purchaseList);
        } catch (Exception ex) {
            result.put("code", 500);
            result.put("msg", "error");
        }
        return result;
    }

    public JSONObject selectPurchaseBySupplier(String supplier) {
        JSONObject result = new JSONObject();
        try {
            List<Purchase> purchaseList = purchaseMapper.selectPurchaseBySupplier(supplier);
            result.put("code", 0);
            result.put("msg", "查询成功");
            result.put("count", purchaseList.size());
            result.put("data", purchaseList);
        } catch (Exception ex) {
            result.put("code", 500);
            result.put("msg", "error");
        }
        return result;
    }

    public JSONObject insertPurchase(Purchase purchase) {
        JSONObject result = new JSONObject();
        try {
            purchaseMapper.insertPurchase(purchase);
            result.put("code", 0);
            result.put("msg", "插入成功");
        } catch (Exception ex) {
            ex.printStackTrace();
            result.put("code", 500);
            result.put("msg", "error");
        }
        return result;
    }

    public JSONObject deletePurchase(int id) {
        JSONObject result = new JSONObject();
        try {
            purchaseMapper.deletePurchase(id);
            result.put("code", 0);
            result.put("msg", "删除成功");
        } catch (Exception ex) {
            result.put("code", 500);
            result.put("msg", "error");
        }
        return result;
    }

    public JSONObject updatePurchase(Purchase purchase) {
        JSONObject result = new JSONObject();
        try {
            purchaseMapper.updatePurchase(purchase);
            result.put("code", 0);
            result.put("msg", "修改成功");
        } catch (Exception ex) {
            result.put("code", 500);
            result.put("msg", "error");
        }
        return result;
    }
}
