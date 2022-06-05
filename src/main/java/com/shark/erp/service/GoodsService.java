package com.shark.erp.service;

import com.alibaba.fastjson.JSONObject;
import com.shark.erp.entity.Goods;
import com.shark.erp.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {
    @Autowired
    GoodsMapper goodsMapper;

    public JSONObject selectAllGoods() {
        JSONObject result = new JSONObject();
        try {
            List<Goods> goodsList = goodsMapper.selectAllGoods();
            result.put("code", 0);
            result.put("msg", "查询成功");
            result.put("count", goodsList.size());
            result.put("data", goodsList);
        } catch (Exception ex) {
            result.put("code", 500);
            result.put("msg", "error");
        }
        return result;
    }

    public JSONObject selectGoodsByName(String name) {
        JSONObject result = new JSONObject();
        try {
            List<Goods> goodsList = goodsMapper.selectGoodsByName(name);
            result.put("code", 0);
            result.put("msg", "查询成功");
            result.put("count", goodsList.size());
            result.put("data", goodsList);
        } catch (Exception ex) {
            result.put("code", 500);
            result.put("msg", "error");
        }
        return result;
    }

    public JSONObject insertGoods(Goods goods) {
        JSONObject result = new JSONObject();
        try {
            goodsMapper.insertGoods(goods);
            result.put("code", 0);
            result.put("msg", "插入成功");
        } catch (Exception ex) {
            result.put("code", 500);
            result.put("msg", "error");
        }
        return result;
    }

    public JSONObject deleteGoods(int id) {
        JSONObject result = new JSONObject();
        try {
            goodsMapper.deleteGoods(id);
            result.put("code", 0);
            result.put("msg", "删除成功");
        } catch (Exception ex) {
            result.put("code", 500);
            result.put("msg", "error");
        }
        return result;
    }

    public JSONObject updateGoods(Goods goods) {
        JSONObject result = new JSONObject();
        try {
            goodsMapper.updateGoods(goods);
            result.put("code", 0);
            result.put("msg", "修改成功");
        } catch (Exception ex) {
            ex.printStackTrace();
            result.put("code", 500);
            result.put("msg", "error");
        }
        return result;
    }

    public JSONObject selectDistinctCategory() {
        JSONObject result = new JSONObject();
        List<String> stringList = goodsMapper.selectDistinctCategory();
        for (int i = 0; i < stringList.size(); i++) {
            result.put(String.valueOf(i + 1), stringList.get(i));
        }
        return result;
    }

    public JSONObject selectGoodsByNameAndCategory(String name, String category) {
        JSONObject result = new JSONObject();
        try {
            List<Goods> goodsList = goodsMapper.selectGoodsByNameAndCategory(name, category);
            result.put("code", 0);
            result.put("msg", "查询成功");
            result.put("count", goodsList.size());
            result.put("data", goodsList);
        } catch (Exception ex) {
            result.put("code", 500);
            result.put("msg", "error");
        }
        return result;
    }
}
