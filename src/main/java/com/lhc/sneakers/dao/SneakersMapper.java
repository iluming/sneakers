package com.lhc.sneakers.dao;

import com.lhc.sneakers.entity.Sneakers;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SneakersMapper {
    List<Sneakers> listSneakers();
    Sneakers getSneakers(int sneakersId);
}
