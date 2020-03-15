package com.lhc.sneakers.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhc.sneakers.constant.ApplyStatus;
import com.lhc.sneakers.entity.InputApply;
import com.lhc.sneakers.entity.Sneakers;
import com.lhc.sneakers.entity.UserInfo;
import com.lhc.sneakers.service.InputApplyService;
import com.lhc.sneakers.service.UserInfoService;
import com.lhc.sneakers.util.Page;
import com.lhc.sneakers.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/InputApply")
public class InputApplyController {
    @Autowired
    InputApplyService inputApplyService;
    @Autowired
    UserInfoService userInfoService;

    @GetMapping("/listInputApply")
    public Map listInputApply(@RequestParam(value="pageNo",defaultValue="1")int pageNo,
                              @RequestParam(value="pageSize",defaultValue="10")int pageSize){
        Map map = new HashMap();
        PageInfo<InputApply> inputApplyPageInfo = inputApplyService.listInputApply(pageNo,pageSize);
        map.put("inputApplyPageInfo",inputApplyPageInfo);
        map.put("listApplyPage",inputApplyPageInfo.getList());
        return map;
    }

    @PostMapping("/addInputApply")
    public Object addInputApply(@RequestBody InputApply inputApply, HttpServletRequest request){
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("UserInfo");
        int userId = userInfo.getUserId();
        inputApply.setApplicantId(userId);

       // inputApply.setApplyTime(new Date());
        inputApply.setStatus(ApplyStatus.WAIT_TO_ENSURE);
        inputApplyService.addInputApply(inputApply);
        return ResultUtil.success();
    }
}
