<%--
  Created by IntelliJ IDEA.
  User: James Jin
  Date: 2021/8/26
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>编辑图书</title>
    <%@include file="/common/success.style.jsp"%>
</head>
<body>
<%@include file="/common/success.head.jsp"%>

<div id="main">
    <form id="bookForm" action="bkupdate" method="post">
        <table>
            <tr>
                <td>名称</td>
                <td>价格</td>
                <td>作者</td>
                <td>销量</td>
                <td>库存</td>
                <td colspan="2">操作</td>
            </tr>
            <tr>
                <td><input id="bname" name="bookName" type="text" value="${bookName}"/></td>
                <td><input id="bprice" name="bookPrice" type="text" value="${bookPrice}"/></td>
                <td><input id="baurthor" name="bookAurthor" type="text" value="${bookAurthor}"/></td>
                <td><input id="bsales" name="bookSale" type="text" value="${bookSale}"/></td>
                <td><input id="brest" name="bookRest" type="text" value="${bookRest}"/></td>
                <td><input id="BkSt"  type="submit" value="提交"/></td>
            </tr>
        </table>
    </form>
    <span id="msg" class="errorMsg">${messageModel.msg}</span>
    <style type="text/css">
        #msg {
            color: red;
            margin-left: 400px;
        }
    </style>
</div>

<%@include file="/common/bottom.jsp"%>
<script src="static/js/jquery-3.6.0.js"></script>
<script src="static/js/bsubmit.js"></script>
</body>
</html>
