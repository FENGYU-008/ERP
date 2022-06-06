package com.shark.erp.mapper;

import com.shark.erp.entity.Purchase;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PurchaseMapper {
    List<Purchase> selectAllPurchase();

    List<Purchase> selectPurchaseBySupplier(@Param("key") String key);

    void insertPurchase(Purchase purchase);

    void deletePurchase(@Param("id") int id);

    void updatePurchase(Purchase purchase);
}
