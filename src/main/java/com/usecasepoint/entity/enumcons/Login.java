package com.usecasepoint.entity.enumcons;

public class Login {
    private String username;
    private String password;
    private Boolean isLogin;
    private String messageLog;

    public Login() {
    }

    public Login(String username, String password, Boolean isLogin, String messageLog) {
        this.username = username;
        this.password = password;
        this.isLogin = isLogin;
        this.messageLog = messageLog;
    }

    public String getMessageLog() {
        return messageLog;
    }

    public void setMessageLog(String messageLog) {
        this.messageLog = messageLog;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getLogin() {
        return isLogin;
    }

    public void setLogin(Boolean login) {
        isLogin = login;
    }
}
