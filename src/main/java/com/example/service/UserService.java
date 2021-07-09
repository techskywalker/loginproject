package com.example.service;

import com.example.entity.User;
import com.example.entity.vo.MessageModel;
import com.example.mapper.UserMapper;
import com.example.util.GetSqlSession;
import com.example.util.StringUtil;
import org.apache.ibatis.session.SqlSession;

public class UserService {
    public MessageModel userLogin(String uname, String upwd) {
        MessageModel messageModel = new MessageModel();

        //回显数据
        User u = new User();
        u.setUserName(uname);
        u.setUserPwd(upwd);
        messageModel.setObject(u);

        //1
        if(StringUtil.isEmpty(uname) || StringUtil.isEmpty(upwd)) {
            messageModel.setCode(0);
            messageModel.setMsg("用户姓名和密码不能为空！");
            return  messageModel;
        }
        //2

        SqlSession session = GetSqlSession.createSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.queryUserByName(uname);

        //3
        if(user == null) {
            messageModel.setCode(0);
            messageModel.setMsg("用户不存在！");
            return messageModel;
        }

        //4
        if(!upwd.equals(user.getUserPwd())) {
            messageModel.setCode(0);
            messageModel.setMsg("用户密码不正确！");
            return messageModel;
        }

        //5
        messageModel.setObject(user);
        return messageModel;
    }
}
