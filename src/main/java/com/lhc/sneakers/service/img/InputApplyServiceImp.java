package com.lhc.sneakers.service.img;

import com.lhc.sneakers.dao.InputApplyMapper;
import com.lhc.sneakers.entity.InputApply;
import com.lhc.sneakers.service.InputApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InputApplyServiceImp implements InputApplyService {
    @Autowired
    InputApplyMapper inputApplyMapper;
    @Override
    public void addInputApply(InputApply inputApply) {
        inputApplyMapper.addInputApply(inputApply);
    }
}
