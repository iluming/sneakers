package com.lhc.sneakers.dao;

import com.lhc.sneakers.entity.InputApply;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OutputApplyMapper {
    void addInputApply(InputApply inputApply);
}
