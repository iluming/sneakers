package com.lhc.sneakers.dao;

import com.lhc.sneakers.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserInfoMapper {
    List<UserInfo> listUser();

    List<UserInfo> listApplyUser();

    void addUser(UserInfo userInfo);
    UserInfo getUser(UserInfo userInfo);

    UserInfo doLogin(UserInfo userInfo);

}
