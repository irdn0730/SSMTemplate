package com.wn32.service.Impl;

import com.wn32.mapper.UserMapper;
import com.wn32.model.User;
import com.wn32.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;
    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User findUserByName(String userName) {

        return userMapper.findfindUserByName(userName);
    }
}
