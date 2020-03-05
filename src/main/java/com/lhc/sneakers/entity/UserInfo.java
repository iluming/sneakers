package com.lhc.sneakers.entity;

import lombok.Data;
import org.springframework.data.annotation.Transient;

@Data
public class UserInfo {

    private int userId;
    private int account;
    private String pwd;
    private String userName;
    private String icon;
    private String company;
    private int telephone;

    @Transient
    private Role role;

    public UserInfo(){}
    public UserInfo(int account, String pwd) {
        this.account = account;
        this.pwd = pwd;
    }

}
