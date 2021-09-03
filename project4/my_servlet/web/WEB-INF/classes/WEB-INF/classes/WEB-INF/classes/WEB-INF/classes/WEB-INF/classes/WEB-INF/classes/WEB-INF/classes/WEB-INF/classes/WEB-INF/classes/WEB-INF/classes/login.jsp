<%--
  Created by IntelliJ IDEA.
  User: James Jin
  Date: 2021/8/25
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录界面</title>
    <link type="text/css" rel="stylesheet" href="static/css/style.css" >
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif" >
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎登录</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>登录图书管理员</h1>
                    <a href="register.jsp">立即注册</a>
                </div>
                <div class="msg_cont">
                    <b></b>
                    <span id="msg" class="errorMsg">${messageModel.msg}</span>
                </div>
                <div class="form">
                    <form action="login" method="post" id="loginForm">
                        <label>用户名称：</label>
                        <input class="itxt" id="uname" value="${messageModel.object.userName}" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="uname" />
                        <br />
                        <br />
                        <label>用户密码：</label>
                        <input class="itxt" id="upwd" value="${messageModel.object.userPwd}"  type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="upwd" />
                        <br />
                        <br />
                        <input type="submit" value="登录" id="loginBtn" />
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%@include file="/common/bottom.jsp"%>
<%--<div style="text-align: center">--%>
<%--    <form action="login" method="post" id="loginForm" >--%>
<%--        姓名：<input id="uname" type="text" name="uname" value="${messageModel.object.userName}" > <br>--%>
<%--        密码：<input id="upwd" type="password" name="upwd" value="${messageModel.object.userPwd}" > <br>--%>
<%--        <span id="msg" style="font-size: 12px;color: red">${messageModel.msg}</span> <br>--%>
<%--        <button type="button" id="loginBtn">登录</button>--%>
<%--        <a href="register.jsp">--%>
<%--            <button href="" type="button" id="registerBtn">注册</button>--%>
<%--        </a>--%>
<%--    </form>--%>
<%--</div>--%>
<%--</body>--%>
<script type="text/javascript" src="static/js/jquery-3.6.0.js"></script>
<script type="text/javascript" src="static/js/login.js"></script>
</html>
