package com.example.entity;
//User实体类

import lombok.Data;

@Data

public class User {

    private Integer userId;
    private String userName;
    private String userPwd;
    private Integer userAge;
}
