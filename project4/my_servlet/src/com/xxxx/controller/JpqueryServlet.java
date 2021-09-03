package com.xxxx.controller;

import com.xxxx.entity.Book;
import com.xxxx.entity.vo.BookPage;
import com.xxxx.entity.vo.MessageModel;
import com.xxxx.service.BookService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/jpquery")
public class JpqueryServlet extends HttpServlet {
    private BookService bookService =new BookService();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int jpPage =Integer.parseInt(request.getParameter("jpPage"));
        MessageModel messageModel2= bookService.getBookList(jpPage);
        if(messageModel2.getCode()==1){
            request.getSession().setAttribute("messageModel2",messageModel2);
            request.getRequestDispatcher("studentmanager.jsp").forward(request,response);
        }else {
            request.getSession().setAttribute("messageModel2",messageModel2);
            response.sendRedirect("studentmanager.jsp");
        }

    }
}
