package com.example.anupa.loginapp;

public class UserInfo {
    public String userName;
    public String userPhno;
    public String userDOB;

    public UserInfo(){

    }

    public UserInfo(String userName, String userPhno, String userDOB) {
        this.userName = userName;
        this.userPhno = userPhno;
        this.userDOB = userDOB;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhno() {
        return userPhno;
    }

    public void setUserPhno(String userPhno) {
        this.userPhno = userPhno;
    }

    public String getUserDOB() {
        return userDOB;
    }

    public void setUserDOB(String userDOB) {
        this.userDOB = userDOB;
    }
}
