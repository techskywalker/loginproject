package com.example.mapper;

import com.example.entity.User;

//用户接口类
public interface UserMapper {
    public User queryUserByName(String userName);
}
