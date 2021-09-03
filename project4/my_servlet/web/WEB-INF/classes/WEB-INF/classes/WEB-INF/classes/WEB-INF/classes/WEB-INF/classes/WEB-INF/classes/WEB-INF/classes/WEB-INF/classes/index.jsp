<%@ page import="com.mysql.cj.xdevapi.SqlSingleResult" %>
<%@ page import="com.xxxx.entity.Book" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: james1148160216
  Date: 2021/8/5
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>图书管理系统</title>
  </head>
  <link type="text/css" rel="stylesheet" href="static/css/style.css" >
<%--  <span>欢迎<span class="um_span">欢迎${messageModel.object.userName}</span>光临系统</span>--%>
  </head>
  <body>

  <div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif" >
    <span class="wel_word">图书管理系统</span>
    <div>
      <span>欢迎<span id="indexname" class="um_span">${user.userName}</span>光临系统</span>
      <a href="login.jsp">登录</a> |
      <a href="register.jsp">注册</a> &nbsp;&nbsp;
    </div>
  </div>

  <div id="main" >
    <table>
      <tr>
        <td>名称</td>
        <td>价格</td>
        <td>作者</td>
        <td>销量</td>
        <td>库存</td>
        <td colspan="2">操作</td>
      </tr>
      <c:if test="${!empty bookList}">
        <c:forEach items="${bookList}" var="book" >
          <tr>
            <td>${book.bookName}</td>
            <td>${book.bookPrice}</td>
            <td>${book.bookAurthor}</td>
            <td>${book.bookSale}</td>
            <td>${book.bookRest}</td>
            <td><a href="book_edit.jsp">修改</a></td>
            <td><a href="#">删除</a></td>
          </tr>
        </c:forEach>
      </c:if>
      <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td><a id="updatebook" href="book_edit.jsp">添加图书</a></td>
      </tr>
    </table>
    <div id="page_nav">
      <a href="#">首页</a>
      <a href="#">上一页</a>
      <a href="#">3</a>
      【4】
      <a href="#">5</a>
      <a href="#">下一页</a>
      <a href="#">末页</a>
      共10页 到第<input value="4" name="pn" id="pn_input"/>页
      <input type="button" value="确定">
    </div>

  <%@include file="/common/bottom.jsp"%>
  <script src="static/js/jquery-3.6.0.js"></script>
  <script src="static/js/index.js"></script>
  </body>
</html>
