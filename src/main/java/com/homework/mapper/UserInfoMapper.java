package com.homework.mapper;

import com.homework.domain.UserDO;

import java.util.List;

/**
 * Created by jiangyayi on 15/12/9.
 */
public interface UserInfoMapper {
    public List<UserDO> getUserDOByUserName(String userName);
    public List<UserDO> getUserDOByUserId(int userId);
}
