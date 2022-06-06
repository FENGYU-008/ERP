package com.shark.erp.service;

import com.alibaba.fastjson.JSONObject;
import com.shark.erp.entity.Order;
import com.shark.erp.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderMapper orderMapper;

    public JSONObject selectAllOrder() {
        JSONObject result = new JSONObject();
        try {
            List<Order> orderList = orderMapper.selectAllOrder();
            result.put("code", 0);
            result.put("msg", "查询成功");
            result.put("count", orderList.size());
            result.put("data", orderList);
        } catch (Exception ex) {
            result.put("code", 500);
            result.put("msg", "error");
        }
        return result;
    }

    public JSONObject selectOrderByCustomerId(int customerId) {
        JSONObject result = new JSONObject();
        try {
            List<Order> orderList = orderMapper.selectOrderByCustomerId(customerId);
            result.put("code", 0);
            result.put("msg", "查询成功");
            result.put("count", orderList.size());
            result.put("data", orderList);
        } catch (Exception ex) {
            ex.printStackTrace();
            result.put("code", 500);
            result.put("msg", "error");
        }
        return result;
    }

    public JSONObject insertOrder(Order order) {
        JSONObject result = new JSONObject();
        try {
            orderMapper.insertOrder(order);
            result.put("code", 0);
            result.put("msg", "插入成功");
        } catch (Exception ex) {
            result.put("code", 500);
            result.put("msg", "error");
        }
        return result;
    }

    public JSONObject deleteOrder(int id) {
        JSONObject result = new JSONObject();
        try {
            orderMapper.deleteOrder(id);
            result.put("code", 0);
            result.put("msg", "删除成功");
        } catch (Exception ex) {
            result.put("code", 500);
            result.put("msg", "error");
        }
        return result;
    }

    public JSONObject updateOrder(Order order) {
        JSONObject result = new JSONObject();
        try {
            orderMapper.updateOrder(order);
            result.put("code", 0);
            result.put("msg", "修改成功");
        } catch (Exception ex) {
            result.put("code", 500);
            result.put("msg", "error");
        }
        return result;
    }
}
