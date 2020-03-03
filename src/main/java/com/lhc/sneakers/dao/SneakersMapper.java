package com.lhc.sneakers.dao;

import com.lhc.sneakers.entity.Sneakers;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SneakersMapper {
    Sneakers getSneakers(int sneakersId);
}
