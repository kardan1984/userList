package com.example.userlist;

import java.util.ArrayList;

// Класс для работы со всеми пользователями
public class Users {
    ArrayList<User> userList;
    // Метод, возвращает список пользователей
    public ArrayList<User> getUserList(){
        // наполняем список пользователями
        this.userList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            User user = new User(); //создаем пользователя
            user.setUserName("Имя_"+(i+1)); //присваиваем ему
            user.setUserLastname("Фамилия_"+(i+1)); //присваеваем ему фамилию
            userList.add(user);//добавляем в массив
        }
        return userList;
    }
}
