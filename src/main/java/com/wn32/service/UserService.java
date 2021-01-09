package com.wn32.service;

import com.wn32.model.User;

public interface UserService {
    User findUserByName(String userName);
}
