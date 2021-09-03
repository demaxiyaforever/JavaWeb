package com.xxxx.controller;

import com.xxxx.service.BookService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/bkdelete")
public class BkdeleteServlet extends HttpServlet {
    private BookService bookService =new BookService();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ubookname = request.getParameter("bookName");
        bookService.bookdelete(ubookname);
        response.sendRedirect("book_delete.success.jsp");
    }
}
