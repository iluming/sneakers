package com.lhc.sneakers.dao;

import com.lhc.sneakers.entity.InputApply;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface InputApplyMapper {
    List<InputApply> listInputApply();
    void addInputApply(InputApply inputApply);

    List<InputApply> yesInputApply(Map map);
}
