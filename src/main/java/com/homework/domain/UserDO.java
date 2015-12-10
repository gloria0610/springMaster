package com.homework.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jiangyayi on 15/12/9.
 */
public class UserDO  implements Serializable{

    private int userId;
    private String userName;
    private int credits;
    private String password;
    private String lastIp;
    private Date lastVisit;

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getLastVisit() {
        return lastVisit;
    }

    public int getCredits() {
        return credits;
    }

    public String getLastIp() {
        return lastIp;
    }

    public int getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

}
