package com.shark.erp.service;

import com.alibaba.fastjson.JSONObject;
import com.shark.erp.entity.ExchangeGoods;
import com.shark.erp.mapper.ExchangeGoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExchangeGoodsService {
    @Autowired
    ExchangeGoodsMapper exchangeGoodsMapper;

    public JSONObject selectAllExchangeGoods() {
        JSONObject result = new JSONObject();
        try {
            List<ExchangeGoods> exchangeGoodsList = exchangeGoodsMapper.selectAllExchangeGoods();
            result.put("code", 0);
            result.put("msg", "查询成功");
            result.put("count", exchangeGoodsList.size());
            result.put("data", exchangeGoodsList);
        } catch (Exception ex) {
            result.put("code", 500);
            result.put("msg", "error");
        }
        return result;
    }

    public JSONObject selectExchangeGoodsByCustomerId(int customerId) {
        JSONObject result = new JSONObject();
        try {
            List<ExchangeGoods> exchangeGoodsList = exchangeGoodsMapper.selectExchangeGoodsByCustomerId(customerId);
            result.put("code", 0);
            result.put("msg", "查询成功");
            result.put("count", exchangeGoodsList.size());
            result.put("data", exchangeGoodsList);
        } catch (Exception ex) {
            ex.printStackTrace();
            result.put("code", 500);
            result.put("msg", "error");
        }
        return result;
    }

    public JSONObject insertExchangeGoods(ExchangeGoods exchangeGoods) {
        JSONObject result = new JSONObject();
        try {
            exchangeGoodsMapper.insertExchangeGoods(exchangeGoods);
            result.put("code", 0);
            result.put("msg", "插入成功");
        } catch (Exception ex) {
            result.put("code", 500);
            result.put("msg", "error");
        }
        return result;
    }

    public JSONObject deleteExchangeGoods(int id) {
        JSONObject result = new JSONObject();
        try {
            exchangeGoodsMapper.deleteExchangeGoods(id);
            result.put("code", 0);
            result.put("msg", "删除成功");
        } catch (Exception ex) {
            result.put("code", 500);
            result.put("msg", "error");
        }
        return result;
    }

    public JSONObject updateExchangeGoods(ExchangeGoods exchangeGoods) {
        JSONObject result = new JSONObject();
        try {
            exchangeGoodsMapper.updateExchangeGoods(exchangeGoods);
            result.put("code", 0);
            result.put("msg", "修改成功");
        } catch (Exception ex) {
            result.put("code", 500);
            result.put("msg", "error");
        }
        return result;
    }

    public JSONObject passExchangeGoodsById(int id) {
        JSONObject result = new JSONObject();
        try {
            exchangeGoodsMapper.passExchangeGoodsById(id);
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
