package com.shark.erp.mapper;

import com.shark.erp.entity.ReturnGoods;
import com.shark.erp.entity.ReturnGoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReturnGoodsMapper {
    List<ReturnGoods> selectAllReturnGoods();

    List<ReturnGoods> selectReturnGoodsByCustomerId(@Param("key") int key);

    void insertReturnGoods(ReturnGoods returnGoods);

    void deleteReturnGoods(@Param("id") int id);

    void updateReturnGoods(ReturnGoods returnGoods);

    void passById(@Param("id") int id);
}
