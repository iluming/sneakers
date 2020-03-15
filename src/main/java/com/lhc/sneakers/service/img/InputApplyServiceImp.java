package com.lhc.sneakers.service.img;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhc.sneakers.dao.InputApplyMapper;
import com.lhc.sneakers.entity.InputApply;
import com.lhc.sneakers.entity.Sneakers;
import com.lhc.sneakers.service.InputApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InputApplyServiceImp implements InputApplyService {
    @Autowired
    InputApplyMapper inputApplyMapper;

    @Override
    public PageInfo<InputApply> listInputApply(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<InputApply> inputApplyList =  inputApplyMapper.listInputApply();
        PageInfo<InputApply> page = new PageInfo<InputApply>(inputApplyList);
        return page;
    }

    @Override
    public void addInputApply(InputApply inputApply) {
        inputApplyMapper.addInputApply(inputApply);
    }
}
