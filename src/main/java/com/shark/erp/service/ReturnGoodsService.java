package com.shark.erp.service;

import com.alibaba.fastjson.JSONObject;
import com.shark.erp.entity.ReturnGoods;
import com.shark.erp.mapper.ReturnGoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturnGoodsService {
    @Autowired
    ReturnGoodsMapper returnGoodsMapper;

    public JSONObject selectAllReturnGoods() {
        JSONObject result = new JSONObject();
        try {
            List<ReturnGoods> returnGoodsList = returnGoodsMapper.selectAllReturnGoods();
            result.put("code", 0);
            result.put("msg", "查询成功");
            result.put("count", returnGoodsList.size());
            result.put("data", returnGoodsList);
        } catch (Exception ex) {
            result.put("code", 500);
            result.put("msg", "error");
        }
        return result;
    }

    public JSONObject selectReturnGoodsByCustomerId(int customerId) {
        JSONObject result = new JSONObject();
        try {
            List<ReturnGoods> returnGoodsList = returnGoodsMapper.selectReturnGoodsByCustomerId(customerId);
            result.put("code", 0);
            result.put("msg", "查询成功");
            result.put("count", returnGoodsList.size());
            result.put("data", returnGoodsList);
        } catch (Exception ex) {
            ex.printStackTrace();
            result.put("code", 500);
            result.put("msg", "error");
        }
        return result;
    }

    public JSONObject insertReturnGoods(ReturnGoods returnGoods) {
        JSONObject result = new JSONObject();
        try {
            returnGoodsMapper.insertReturnGoods(returnGoods);
            result.put("code", 0);
            result.put("msg", "插入成功");
        } catch (Exception ex) {
            result.put("code", 500);
            result.put("msg", "error");
        }
        return result;
    }

    public JSONObject deleteReturnGoods(int id) {
        JSONObject result = new JSONObject();
        try {
            returnGoodsMapper.deleteReturnGoods(id);
            result.put("code", 0);
            result.put("msg", "删除成功");
        } catch (Exception ex) {
            result.put("code", 500);
            result.put("msg", "error");
        }
        return result;
    }

    public JSONObject updateReturnGoods(ReturnGoods returnGoods) {
        JSONObject result = new JSONObject();
        try {
            returnGoodsMapper.updateReturnGoods(returnGoods);
            result.put("code", 0);
            result.put("msg", "修改成功");
        } catch (Exception ex) {
            result.put("code", 500);
            result.put("msg", "error");
        }
        return result;
    }

    public JSONObject passById(int id) {
        JSONObject result = new JSONObject();
        try {
            returnGoodsMapper.passById(id);
            result.put("code", 0);
            result.put("msg", "操作成功");
        } catch (Exception ex) {
            ex.printStackTrace();
            result.put("code", 500);
            result.put("msg", "error");
        }
        return result;
    }
}
