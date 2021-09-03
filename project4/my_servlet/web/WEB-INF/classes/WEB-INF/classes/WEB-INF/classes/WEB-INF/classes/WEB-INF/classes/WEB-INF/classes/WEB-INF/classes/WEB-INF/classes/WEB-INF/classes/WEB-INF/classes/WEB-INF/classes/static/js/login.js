$("#loginBtn").click(function (e) {
    e.preventDefault();
    var uname = $("#uname").val();
    var upwd = $("#upwd").val();
    if(isEmpty(uname)){
        $("#msg").html("用户名不可为空");
        return ;
    }
    if(isEmpty(upwd)){
        $("#msg").html("密码不可为空");
        return ;
    }
    $("#loginForm").submit();
});

function isEmpty(str) {
    if(str =null||str.trim() == ""){
        return true;
    }
    return false;
}

