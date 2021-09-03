package com.xxxx.controller;

import com.xxxx.entity.Book;
import com.xxxx.entity.vo.MessageModel;
import com.xxxx.service.BookService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/bkupdate")
public class BkupdateServlet extends HttpServlet {
    private BookService bookService =new BookService();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String BName=request.getParameter("bookName");
        String BPrice=request.getParameter("bookPrice");
        String BAurthor=request.getParameter("bookAurthor");
        String BSales=request.getParameter("bookSale");
        String BRest=request.getParameter("bookRest");
        MessageModel messageModel=bookService.bookupdate(BName,BPrice,BAurthor,BSales,BRest);
        request.setAttribute("book",messageModel.getObject());
        if(messageModel.getCode()==1) {
            request.getSession().setAttribute("book", messageModel.getObject());
            response.sendRedirect("book_edit.success.jsp");
        } else{
            request.setAttribute("messageModel",messageModel);
            request.getRequestDispatcher("book_edit.jsp").forward(request,response);
        }
    }
}
