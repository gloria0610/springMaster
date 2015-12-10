package com.homework.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jiangyayi on 15/12/9.
 */
public class LoginLogDO implements Serializable{
    private int loginLogId;
    private int userId;
    private String ip;
    private Date loginDate;

    public int getUserId() {
        return userId;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public void setLoginLogId(int loginLogId) {
        this.loginLogId = loginLogId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public int getLoginLogId() {
        return loginLogId;
    }

    public String getIp() {
        return ip;
    }


}
