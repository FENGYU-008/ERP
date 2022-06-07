package com.shark.erp.entity;

/**
 * 商品监控实体类
 */
public class GoodsMonitor {
    private int id; //商品ID
    private String goodsName; // 商品名称
    private int timeDiff; //当前时间和保质期的时间差
    private int inventory; //库存量

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getTimeDiff() {
        return timeDiff;
    }

    public void setTimeDiff(int timeDiff) {
        this.timeDiff = timeDiff;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}
