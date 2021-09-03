package com.xxxx.controller;

import com.xxxx.entity.vo.MessageModel;
import com.xxxx.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")

public class RegisterServlet extends HttpServlet {
    private UserService userService =new UserService();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname= request.getParameter("uname");
        String upwd= request.getParameter("upwd");
        String uemail = request.getParameter("uemail");
        MessageModel messageModel = userService.userRegisterin(uname,upwd,uemail);
        if(messageModel.getCode() ==1){
            request.setAttribute("user",messageModel.getObject());
            response.sendRedirect("register.success.jsp");
        }else {
            request.setAttribute("messageModel",messageModel);
            request.getRequestDispatcher("register.jsp").forward(request,response);
        }
    }
}
