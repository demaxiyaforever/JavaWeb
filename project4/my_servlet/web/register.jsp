<%--
  Created by IntelliJ IDEA.
  User: James Jin
  Date: 2021/8/6
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册界面</title>
    <link type="text/css" rel="stylesheet" href="static/css/style.css" >
    <style type="text/css">
        .login_form{
            height:420px;
            margin-top: 25px;
        }

    </style>
</head>
<body>
<%--<div style="text-align: center">--%>
<%--    <form action="register" method="post" id="registerForm" >--%>
<%--        姓名：<input id="uname" type="text" name="uname" value="${messageModel.object.userName}" > <br>--%>
<%--        密码：<input id="upwd" type="password" name="upwd" value="${messageModel.object.userPwd}" > <br>--%>
<%--        邮箱：<input id="uemail" type="email" name="uemail" value="${messageModel.object.email}" > <br>--%>
<%--        <span id="msg" style="font-size: 12px;color: red">${messageModel.msg}</span> <br>--%>
<%--        <button type="button" id="registerBtn">注册</button>--%>
<%--    </form>--%>
<%--</div>--%>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif" >
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册图书管理员</h1>
                    <span id="msg" class="errorMsg">${messageModel.msg}</span>
                </div>
                <div class="form">
                    <form action="register" method="post" id="registerForm">
                        <label>用户名称：</label>
                        <input class="itxt" id="uname" type="text" placeholder="请输入用户名"
                               autocomplete="off" tabindex="1" name="uname" value="${messageModel.object.userName}" />
                        <br />
                        <br />
                        <label>用户密码：</label>
                        <input class="itxt"  id="upwd" type="password" placeholder="请输入密码"
                               autocomplete="off" tabindex="1" name="upwd" value="${messageModel.object.userPwd}"/>
                        <br />
                        <br />
                        <label>电子邮件：</label>
                        <input class="itxt"  id="uemail" type="email" placeholder="请输入邮箱地址"
                               autocomplete="off" tabindex="1" name="uemail" value="${messageModel.object.email}"/>
                        <br />
                        <br />
                        <input type="submit" value="注册" id="registerBtn" />
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%@include file="/common/bottom.jsp"%>
<script src="static/js/jquery-3.6.0.js"></script>
<script src="static/js/register.js"></script>
</body>
</html>
