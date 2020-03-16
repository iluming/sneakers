package com.lhc.sneakers.service;

import com.github.pagehelper.PageInfo;
import com.lhc.sneakers.entity.InputApply;

import java.util.List;
import java.util.Map;

public interface InputApplyService {
    PageInfo<InputApply> listInputApply(int pageNo, int pageSize);

    void addInputApply(InputApply inputApply);

    Map yesInputApply(int pageNo, int pageSize);

}
