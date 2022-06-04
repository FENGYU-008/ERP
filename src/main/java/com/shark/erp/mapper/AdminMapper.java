package com.shark.erp.mapper;

import com.shark.erp.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    Admin getByUsernameAndPassword(Admin admin);
}
