package com.xxxx.mapper;

import com.xxxx.entity.User;

public interface UserMapper {
    public User queryUserByName(String userName);

    public int saveUser(User user);

    public void updateid();
}
