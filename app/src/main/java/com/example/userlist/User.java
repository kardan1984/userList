package com.example.userlist;

// Создание класса для подьзователя (User)
public class User {
    private String userName;
    private String userLastname;
    private String phone;


    // Создаем get-ры и set-ры
    public String getUserName() {
        return userName;
    }

    public String getUserLastname() {
        return userLastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserLastname(String userLastname) {
        this.userLastname = userLastname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}