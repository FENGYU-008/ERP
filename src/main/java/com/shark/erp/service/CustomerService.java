package com.shark.erp.service;

import com.alibaba.fastjson.JSONObject;
import com.shark.erp.entity.Customer;
import com.shark.erp.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerMapper customerMapper;

    public JSONObject selectAllCustomer() {
        JSONObject result = new JSONObject();
        try {
            List<Customer> customerList = customerMapper.selectAllCustomer();
            result.put("code", 0);
            result.put("msg", "查询成功");
            result.put("count", customerList.size());
            result.put("data", customerList);
        } catch (Exception ex) {
            result.put("code", 500);
            result.put("msg", "error");
        }
        return result;
    }

    public JSONObject selectCustomerByName(String name) {
        JSONObject result = new JSONObject();
        try {
            List<Customer> customerList = customerMapper.selectCustomerByName(name);
            result.put("code", 0);
            result.put("msg", "查询成功");
            result.put("count", customerList.size());
            result.put("data", customerList);
        } catch (Exception ex) {
            result.put("code", 500);
            result.put("msg", "error");
        }
        return result;
    }

    public JSONObject insertCustomer(Customer customer) {
        JSONObject result = new JSONObject();
        try {
            customerMapper.insertCustomer(customer);
            result.put("code", 0);
            result.put("msg", "插入成功");
        } catch (Exception ex) {
            result.put("code", 500);
            result.put("msg", "error");
        }
        return result;
    }

    public JSONObject deleteCustomer(int id) {
        JSONObject result = new JSONObject();
        try {
            customerMapper.deleteCustomer(id);
            result.put("code", 0);
            result.put("msg", "删除成功");
        } catch (Exception ex) {
            result.put("code", 500);
            result.put("msg", "error");
        }
        return result;
    }

    public JSONObject updateCustomer(Customer customer) {
        JSONObject result = new JSONObject();
        try {
            customerMapper.updateCustomer(customer);
            result.put("code", 0);
            result.put("msg", "修改成功");
        } catch (Exception ex) {
            result.put("code", 500);
            result.put("msg", "error");
        }
        return result;
    }
}
