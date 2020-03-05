package com.lhc.sneakers.controller;

import com.lhc.sneakers.entity.InputApply;
import com.lhc.sneakers.entity.UserInfo;
import com.lhc.sneakers.service.InputApplyService;
import com.lhc.sneakers.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/InputApply")
public class InputApplyController {
    @Autowired
    InputApplyService inputApplyService;
    @Autowired
    UserInfoService userInfoService;

    @PostMapping("/addInputApply")
    public String addInputApply(@RequestBody InputApply inputApply, HttpServletRequest request){
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("UserInfo");
        int userId = userInfo.getUserId();
        inputApply.setApplicantId(userId);
        inputApplyService.addInputApply(inputApply);
        return "ok";
    }
}
