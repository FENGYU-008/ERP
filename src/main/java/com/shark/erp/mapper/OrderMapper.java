package com.shark.erp.mapper;

import com.shark.erp.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    List<Order> selectAllOrder();

    List<Order> selectOrderByCustomerId(@Param("key") int key);

    void insertOrder(Order order);

    void deleteOrder(@Param("id") int id);

    void updateOrder(Order order);

    String selectSalesAmount();
}
