<%--
  Created by IntelliJ IDEA.
  User: James Jin
  Date: 2021/8/29
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>提交成功页面</title>
    <%@ include file="/common/success.style.jsp"%>
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

<div id="main">
    <table id="bst">
        <h1 id="bsh">欢迎回来 <a href="bkquery">返回</a></h1>
    </table>
</div>

<%@include file="/common/bottom.jsp"%>
<script src="static/js/jquery-3.6.0.js"></script>
<script src="static/js/book_edit.success.js"></script>
</body>
</html>
