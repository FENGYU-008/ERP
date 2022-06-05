package com.shark.erp.mapper;

import com.shark.erp.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CustomerMapper {
    List<Customer> selectAllCustomer();

    List<Customer> selectCustomerByName(@Param("key") String key);

    void insertCustomer(Customer customer);

    void deleteCustomer(@Param("id") int id);

    void updateCustomer(Customer customer);
}
