package com.shark.erp.controller;

import com.alibaba.fastjson.JSONObject;
import com.shark.erp.entity.Customer;
import com.shark.erp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @ResponseBody
    @GetMapping("/selectAllCustomer")
    public JSONObject selectAllCustomer() {
        return customerService.selectAllCustomer();
    }

    @ResponseBody
    @GetMapping("/selectCustomerByName")
    public JSONObject selectCustomerByName(@RequestParam("name") String name) {
        return customerService.selectCustomerByName(name);
    }

    @ResponseBody
    @PostMapping("/insertCustomer") //获取前端传来的json参数
    public JSONObject insertCustomer(@RequestBody Customer customer) {
        return customerService.insertCustomer(customer);
    }

    @ResponseBody
    @DeleteMapping("/deleteCustomer")
    public JSONObject deleteCustomer(@RequestParam("id") int id) {
        return customerService.deleteCustomer(id);
    }

    @ResponseBody
    @PostMapping("/updateCustomer")
    public JSONObject updateCustomer(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }

    /**
     * 区分该表单请求是添加还是修改
     */
    @PostMapping("/customerAction")
    public String customerAction(@RequestParam("action") String action) {
        if (action.equals("edit")) {
            return "forward:/updateCustomer";
        } else if (action.equals("add")) {
            return "forward:/insertCustomer";
        }
        return "404";
    }
}
