package com.shark.erp.mapper;

import com.shark.erp.entity.ExchangeGoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ExchangeGoodsMapper {
    List<ExchangeGoods> selectAllExchangeGoods();

    List<ExchangeGoods> selectExchangeGoodsByCustomerId(@Param("key") int key);

    void insertExchangeGoods(ExchangeGoods exchangeGoods);

    void deleteExchangeGoods(@Param("id") int id);

    void updateExchangeGoods(ExchangeGoods exchangeGoods);

    void passExchangeGoodsById(@Param("id") int id);
}
