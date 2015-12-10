package com.homework.dao;

import com.homework.domain.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jiangyayi on 15/12/9.
 */
@Repository
public class UserDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int getMatchCount(String userName,String passworld){
        String sqlStr="select count(*) from t_user where user_name=? and password=?";
        return jdbcTemplate.queryForInt(sqlStr,new Object[]{userName,passworld});
    }


    public UserDO findUserByUserName(final String userName){
        String sqlStr="select user_id,user_name,credits from t_user where user_name=?";
        final UserDO userDO=new UserDO();
        jdbcTemplate.query(sqlStr, new Object[]{userName},
                new RowCallbackHandler() {
                    @Override
                    public void processRow(ResultSet rs) throws SQLException {
                        userDO.setUserId(rs.getInt("user_id"));
                        userDO.setUserName(userName);
                        userDO.setCredits(rs.getInt("credits"));
                    }
                });
        return userDO;
    }

    public void updateLoginInfo(UserDO userDO){
        String sqlStr="update t_user set last_visit=?,last_ip=?,credits=? where user_id=?";
        jdbcTemplate.update(sqlStr,new Object[]{userDO.getLastVisit(),userDO.getLastIp(),userDO.getCredits(),userDO.getUserId()});
    }

}
