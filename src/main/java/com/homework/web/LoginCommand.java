package com.homework.web;

/**
 * Created by jiangyayi on 15/12/10.
 */
public class LoginCommand {
    private String userName;
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }
}

