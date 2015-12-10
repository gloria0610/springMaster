package com.homework.service;

import com.homework.dao.LoginLogDAO;
import com.homework.dao.UserDAO;
import com.homework.domain.LoginLogDO;
import com.homework.domain.UserDO;
import com.homework.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by jiangyayi on 15/12/9.
 */
@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;
    @Resource
    private UserInfoMapper userInfoMapper;
    @Autowired
    private LoginLogDAO loginLogDAO;

    public boolean hasMatchUser(String userName,String password){
        int matchCount=userDAO.getMatchCount(userName,password);
        return matchCount>0;
    }

    public UserDO findUserByUserName(String userName){
        return userDAO.findUserByUserName(userName);
    }

    public UserDO getUserByUserName(String userName){
        if(null!=userInfoMapper.getUserDOByUserName(userName)){
        return userInfoMapper.getUserDOByUserName(userName).get(0);
        } else
            return null;
    }

    public void loginSuccess(UserDO userDO){
        userDO.setCredits(5+userDO.getCredits());
        LoginLogDO loginLogDO=new LoginLogDO();
        loginLogDO.setUserId(userDO.getUserId());
        loginLogDO.setIp(userDO.getLastIp());
        loginLogDO.setLoginDate(userDO.getLastVisit());
        userDAO.updateLoginInfo(userDO);
        loginLogDAO.insertLoginLog(loginLogDO);
    }


}
