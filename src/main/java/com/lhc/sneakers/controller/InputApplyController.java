package com.lhc.sneakers.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhc.sneakers.constant.ApplyStatus;
import com.lhc.sneakers.entity.InputApply;
import com.lhc.sneakers.entity.Sneakers;
import com.lhc.sneakers.entity.UserInfo;
import com.lhc.sneakers.exception.MyException;
import com.lhc.sneakers.service.InputApplyService;
import com.lhc.sneakers.service.UserInfoService;
import com.lhc.sneakers.util.Page;
import com.lhc.sneakers.util.ResultCode;
import com.lhc.sneakers.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    /**
     *
     * @param pageNo
     * @param pageSize
     * @param code 1为我的入库申请，2待处理入库申请，3入库历史
     * @return
     */
    @GetMapping("/listInputApply")
    public Object listInputApply(@RequestParam(value="pageNo",defaultValue="1")int pageNo,
                              @RequestParam(value="pageSize",defaultValue="10")int pageSize,
                              @RequestParam(value="code",defaultValue = "1")int code,
                              HttpSession session){
        Map map = new HashMap();
        UserInfo userInfo = (UserInfo) session.getAttribute("UserInfo");
        if(null==userInfo)
            throw new MyException(ResultCode.NOT_LOGIN);
        int applicantId = userInfo.getUserId();
        PageInfo<InputApply> inputApplyPageInfo = inputApplyService.listInputApply(pageNo,pageSize,applicantId,code);
        map.put("inputApplyPageInfo",inputApplyPageInfo);
        return ResultUtil.success(map);
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

    /***
     * 首页 入库出库的数据
     * @return
     */
    @GetMapping("/mainInputApply")
    public Map mainInputApply(@RequestParam(value="pageNo",defaultValue="1")int pageNo,
                              @RequestParam(value="pageSize",defaultValue="10")int pageSize){
        Map map = new HashMap();
        Map map1 = inputApplyService.yesInputApply(pageNo,pageSize);

        map.put("inputApplyList",map1);
        return map;


    }

    @DeleteMapping("/listInputApply/{inputApplyId}")
    public String deleteInputApply(@PathVariable("inputApplyId") int inputApplyId){
        inputApplyService.deleteInputApply(inputApplyId);
        return null;
    }

    @PutMapping("/listInputApply/{inputApplyId}")
    public Object updateInputStatus(@PathVariable("inputApplyId") int inputApplyId,
                                    @RequestParam("status") String status) {
        Map map = new HashMap();
        map.put("inputApplyId",inputApplyId);
        map.put("status",status);
        inputApplyService.updateInputStatus(map);

        return ResultUtil.success();
    }
}
