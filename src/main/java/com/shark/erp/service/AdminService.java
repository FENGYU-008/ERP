package com.shark.erp.service;

import com.alibaba.fastjson.JSONObject;
import com.shark.erp.entity.Admin;
import com.shark.erp.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    AdminMapper adminMapper;

    public JSONObject getByUsernameAndPassword(Admin loginAdmin) {
        JSONObject result = new JSONObject();
        try {
            Admin admin = adminMapper.getByUsernameAndPassword(loginAdmin);
            if (admin == null) {
                result.put("code", 401);
                result.put("msg", "账号或密码错误");
            } else {
                result.put("code", 200);
                result.put("msg", "登录成功");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            result.put("code", 500);
            result.put("msg", "出现了不可描述的错误~");
        }
        return result;
    }
}
