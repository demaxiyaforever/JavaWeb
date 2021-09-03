package com.xxxx.entity;

/*
    用户实体类


 */
public class User {
    private Integer userId;
    private String userName;
    private String userPwd;
    private String Email;

    public User(){

    }
    public User(String userName,String userPwd,String Email) {
        this.userName=userName;
        this.userPwd=userPwd;
        this.Email=Email;
    }




    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }


}
