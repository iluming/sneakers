package com.lhc.sneakers.service;

import com.lhc.sneakers.entity.UserInfo;

import java.util.List;

public interface UserInfoService {
    List<UserInfo> listUser();
    void addUser(UserInfo userInfo);
    UserInfo getUser(UserInfo userInfo);

    UserInfo doLogin(UserInfo userInfo);
}
