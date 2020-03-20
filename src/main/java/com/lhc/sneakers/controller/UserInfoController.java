package com.lhc.sneakers.controller;

import com.lhc.sneakers.entity.UserInfo;
import com.lhc.sneakers.exception.MyException;
import com.lhc.sneakers.service.UserInfoService;
import com.lhc.sneakers.util.EncrypeUtil;
import com.lhc.sneakers.util.ResultCode;
import com.lhc.sneakers.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import static com.sun.xml.internal.ws.api.model.wsdl.WSDLBoundOperation.ANONYMOUS.required;

@RestController
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;

    @PostMapping("/login")
    public Object login( HttpSession session,
                        @RequestParam(value = "account")String account,
                        @RequestParam(value = "pwd" ) String pwd) throws Exception {
        UserInfo userInfo = new UserInfo(account, pwd);
        userInfo.setPwd(EncrypeUtil.shaEncode(userInfo.getPwd()));
        UserInfo userInfo1 = userInfoService.doLogin(userInfo);
        if (null == userInfo1) {
            throw new MyException(ResultCode.NOT_ACCOUNT);
        }
        session.setAttribute("UserInfo", userInfo1);
        System.out.println(session.getAttribute("UserInfo"));
        return ResultUtil.success();
    }

    @PostMapping("/register")
    public Object register(@RequestBody UserInfo userInfo) throws Exception {
      /*  UserInfo userInfo1 = userInfoService.getUser(userInfo);
        if (null != userInfo1){
            return  ResultUtil.success("账号已存在");
        }*/
    //    userInfo.setAccount(userInfo.getTelephone());
        userInfo.setPwd(EncrypeUtil.shaEncode(userInfo.getPwd()));
        userInfoService.addUser(userInfo);
        return ResultUtil.success("注册成功，等待管理员通过");
    }

    @GetMapping("/listApplyUser")
    public Object listApplyUser(){
        List<UserInfo> userInfoList = userInfoService.listApplyUser();
        return ResultUtil.success(userInfoList);
    }
}
