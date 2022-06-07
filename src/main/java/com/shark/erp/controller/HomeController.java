package com.shark.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String Hello() {
        return "/login";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/customer")
    public String customer() {
        return "customer";
    }

    @RequestMapping("/goods")
    public String goods() {
        return "goods";
    }

    @RequestMapping("/purchase")
    public String purchase() {
        return "purchase";
    }

    @RequestMapping("/order")
    public String order() {
        return "order";
    }

    @RequestMapping("/return_goods")
    public String return_goods() {
        return "return_goods";
    }

    @RequestMapping("/exchange_goods")
    public String exchange_goods() {
        return "exchange_goods";
    }

    @RequestMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @RequestMapping("/goods_monitor")
    public String goods_monitor() {
        return "goods_monitor";
    }
}
