package com.example.test;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

public class Test {
    public static void main(String[] args) {
        //获得sqlSession对象
        SqlSession session = GetSqlSession.createSqlSession();
        //得到对应mapper
        UserMapper userMapper = session.getMapper(UserMapper.class);
        //调用方法，返回用户对象
        User user = userMapper.queryUserByName("admin");
        System.out.println(user);
    }
}
