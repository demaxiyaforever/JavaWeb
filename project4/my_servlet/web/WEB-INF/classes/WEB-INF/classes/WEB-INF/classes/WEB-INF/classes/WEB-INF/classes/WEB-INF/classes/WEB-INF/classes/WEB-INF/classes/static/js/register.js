$("#registerBtn").click(function (e) {
    e.preventDefault();
    var uname = $("#uname").val();
    var upwd = $("#upwd").val();
    var uemail =$("#uemail").val();
    if(isEmpty(uname)){
        $("#msg").html("用户名不可为空");
        return ;
    }
    if(isEmpty(upwd)){
        $("#msg").html("密码不可为空");
        return ;
    }
    if(isEmpty(uemail)){
        $("#msg").html("邮箱不可为空");
        return ;
    }
    $("#registerForm").submit();
});

function isEmpty(str) {
    if(str =null||str.trim() == ""){
        return true;
    }
    return false;
}