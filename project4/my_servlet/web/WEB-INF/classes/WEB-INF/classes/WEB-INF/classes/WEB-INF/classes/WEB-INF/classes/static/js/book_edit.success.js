var iname=$("#indexname").text();
if(iname==""){
    $("#bsh").replaceWith("<h1>请登录后使用</h1><style type=\"text/css\">\n" +
        "        h1 {\n" +
        "            text-align: center;\n" +
        "            margin-top: 200px;\n" +
        "            font-size:300%;\n "+
        "        }\n" +
        "    </style>");
}