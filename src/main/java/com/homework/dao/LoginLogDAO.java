package com.homework.dao;

import com.homework.domain.LoginLogDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


/**
 * Created by jiangyayi on 15/12/9.
 */
@Repository
public class LoginLogDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertLoginLog(LoginLogDO loginLog){
        String sqlStr="insert into t_login_log(user_id,ip,login_date_time) values(?,?,?)";
        Object[] args={loginLog.getUserId(),loginLog.getIp(),loginLog.getLoginDate()};
        jdbcTemplate.update(sqlStr,args);
    }
}
