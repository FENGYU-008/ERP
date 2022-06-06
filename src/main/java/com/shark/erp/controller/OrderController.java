package com.shark.erp.controller;

import com.alibaba.fastjson.JSONObject;
import com.shark.erp.entity.Order;
import com.shark.erp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    @ResponseBody
    @GetMapping("/selectAllOrder")
    public JSONObject selectAllOrder() {
        return orderService.selectAllOrder();
    }

    @ResponseBody
    @GetMapping("/selectOrderByCustomerId")
    public JSONObject selectOrderByCustomerId(@RequestParam("customerId") int customerId) {
        return orderService.selectOrderByCustomerId(customerId);
    }

    @ResponseBody
    @PostMapping("/insertOrder") //获取前端传来的json参数
    public JSONObject insertOrder(@RequestBody Order order) {
        return orderService.insertOrder(order);
    }

    @ResponseBody
    @DeleteMapping("/deleteOrder")
    public JSONObject deleteOrder(@RequestParam("id") int id) {
        return orderService.deleteOrder(id);
    }

    @ResponseBody
    @PostMapping("/updateOrder")
    public JSONObject updateOrder(@RequestBody Order order) {
        return orderService.updateOrder(order);
    }

    /**
     * 区分该表单请求是添加还是修改
     */
    @PostMapping("/orderAction")
    public String orderAction(@RequestParam("action") String action) {
        if (action.equals("edit")) {
            return "forward:/updateOrder";
        } else if (action.equals("add")) {
            return "forward:/insertOrder";
        }
        return "404";
    }
}
