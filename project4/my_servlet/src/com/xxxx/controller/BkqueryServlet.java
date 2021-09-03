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

//@WebServlet("/bkquery")
//public class BkqueryServlet extends HttpServlet {
//    private BookService bookService = new BookService();
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request,response);
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Book> bookList =bookService.getBookList();
//        request.getSession().setAttribute("bookList",bookList);
//        request.getRequestDispatcher("studentmanager.jsp").forward(request,response);
//    }
//}
@WebServlet("/bkquery")
public class BkqueryServlet extends HttpServlet {
    private BookService bookService = new BookService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MessageModel messageModel2= bookService.getBookList(1);
        request.getSession().setAttribute("messageModel2",messageModel2);
        request.getRequestDispatcher("studentmanager.jsp").forward(request,response);
    }
}

