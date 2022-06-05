package com.shark.erp.mapper;

import com.shark.erp.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsMapper {
    List<Goods> selectAllGoods();

    List<Goods> selectGoodsByName(@Param("key") String key);

    void insertGoods(Goods goods);

    void deleteGoods(@Param("id") int id);

    void updateGoods(Goods goods);

    List<String> selectDistinctCategory();

    List<Goods> selectGoodsByNameAndCategory(@Param("name") String name, @Param("category") String category);
}
