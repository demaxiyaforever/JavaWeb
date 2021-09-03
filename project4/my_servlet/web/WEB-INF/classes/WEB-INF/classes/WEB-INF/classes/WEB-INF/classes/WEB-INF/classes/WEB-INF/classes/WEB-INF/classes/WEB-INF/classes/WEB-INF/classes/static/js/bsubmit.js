var iname=$("#bhide").text();
if(iname==""){
    $("table").replaceWith("<h1>请登录后使用</h1><style type=\"text/css\">\n" +
        "        h1 {\n" +
        "            text-align: center;\n" +
        "            margin-top: 200px;\n" +
        "            font-size:300%;\n "+
        "        }\n" +
        "    </style>");
}

$("#BkSt").click(function (e) {
    e.preventDefault();
    var bname = $("#bname").val();
    var bprice = $("#bprice").val();
    var baurthor = $("#baurthor").val();
    var bsales = $("#bsales").val();
    var brest = $("#brest").val();
    if(isEmpty(bname)){
        $("#msg").html("书名不可为空");
        return ;
    }
    if(isEmpty(bprice)){
        $("#msg").html("价格不可为空");
        return ;
    }
    if(isEmpty(baurthor)){
        $("#msg").html("作者不可为空");
        return ;
    }
    if(isEmpty(bsales)){
        $("#msg").html("销量不可为空");
        return ;
    }
    if(isEmpty(brest)){
        $("#msg").html("货存不可为空");
        return ;
    }
    $("#bookForm").submit();
});

function isEmpty(str) {
    if(str =null||str.trim() == ""){
        return true;
    }
    return false;
}

