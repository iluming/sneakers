package com.lhc.sneakers.dao;

import com.lhc.sneakers.entity.Warehouse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WarehouseMapper {
    List<Warehouse> list(int sneakersId);

    List<Warehouse> spareWH();
}
