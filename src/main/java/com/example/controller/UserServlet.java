package com.example.controller;

import com.example.entity.vo.MessageModel;
import com.example.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class UserServlet extends HttpServlet {
    //实力化
    private UserService userService = new UserService();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收请求
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");
        //调用service层的方法
        MessageModel messageModel = userService.userLogin(uname,upwd);
        if(messageModel.getCode() == 1) {
            request.getSession().setAttribute("user",messageModel.getObject());
            response.sendRedirect("index.jsp");
        }else {
            //失败
            request.setAttribute("messageModel",messageModel);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }
}
