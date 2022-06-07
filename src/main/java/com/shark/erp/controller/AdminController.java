package com.shark.erp.controller;

import com.alibaba.fastjson.JSONObject;
import com.shark.erp.entity.Admin;
import com.shark.erp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @ResponseBody
    @PostMapping("/admin/doLogin")
    public JSONObject doLogin(@RequestBody Admin loginAdmin, HttpSession session) {
        JSONObject result = adminService.getByUsernameAndPassword(loginAdmin);
        if (result.getInteger("code") == 200) {
            session.setAttribute("user", loginAdmin);
        }
        return result;
    }

    @RequestMapping("/admin/doLogout")
    public String doLogout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/login";
    }
}
