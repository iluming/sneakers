package com.lhc.sneakers.service.img;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhc.sneakers.dao.InputApplyMapper;
import com.lhc.sneakers.entity.InputApply;
import com.lhc.sneakers.entity.Sneakers;
import com.lhc.sneakers.service.InputApplyService;
import com.lhc.sneakers.util.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 上周入库量和具体数据
     * @return
     */
    @Override
    public Map yesInputApply(int pageNo, int pageSize) {
        Map map = new HashMap();
        Date date = new Date();

        //总量
        PageHelper.startPage(pageNo,pageSize);
        List<InputApply> totalInput = inputApplyMapper.yesInputApply(map);
        PageInfo<InputApply> pageTotalInput = new PageInfo<InputApply>(totalInput);
        map.put("totalInput",pageTotalInput);
        map.put("totalInputNum",sumNum(totalInput));

        Date startTime = DateTimeUtils.geLastWeekMonday(date);
        Date endTime = DateTimeUtils.getThisWeekMonday(date);
        System.out.println("startTime"+DateTimeUtils.dateToString(startTime));
        map.put("startTime",startTime);
        map.put("endTime",endTime);

        //上周量
        PageHelper.startPage(pageNo,pageSize);
        List<InputApply> lastWeekInput = inputApplyMapper.yesInputApply(map);
        PageInfo<InputApply> pageLastWeekInput = new PageInfo<InputApply>(lastWeekInput);
        map.put("lastWeekInput",pageLastWeekInput);

        map.put("lastWeekInputNum",sumNum(lastWeekInput));
        return map;
    }

    public int sumNum(List<InputApply> inputApplies){
        int sumNum = 0;

        for (int i = 0; i<inputApplies.size(); i++){
            sumNum = inputApplies.get(i).getSumNum() +sumNum;
        }
        return sumNum;
    }
}
