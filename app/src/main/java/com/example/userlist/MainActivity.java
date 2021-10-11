package com.example.userlist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView; // Объявляем переменную recyclerView
    UserAdapter userAdapter; // Объявляем переменную userAdapter
    //ArrayList<String> usersName = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*for (int i = 0; i < 100; i++) {
            usersName.add("User_"+i);
        }*/

        recyclerView = findViewById(R.id.recyclerView); // Связь пременной по идентификатору
        // Метод - устанавливаем макет на LinearLayout (элеметны друг под другом)
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        Users users = new Users();//создаем объект Users
        userAdapter = new UserAdapter(users.getUserList()); //создаем новый объект userAdapter
        recyclerView.setAdapter(userAdapter); //Устанавливаем Adapter для recyclerView
    }

    // Класс UserHolder создает один элемент списка (его структуру)
    private class UserHolder extends RecyclerView.ViewHolder{
        TextView itemTextView;
        String userName;
        // Конструктор для класса UserHolder (аргументы: inflater + viewGroup)
        public UserHolder(LayoutInflater inflater, ViewGroup viewGroup) {
            //Вызов родительского конструтора для создания макета 1-го элемента списка
            super(inflater.inflate(R.layout.single_item, viewGroup, false));
            itemTextView = itemView.findViewById(R.id.itemTextView);// Привязка по id itemTextView
        }
        // Привязка имени пользователя к элементу списка
        public void bind(String userName){
            this.userName = userName;
            itemTextView.setText(userName);
        }
    }

    // Класс UserAdapter размещает элементы списка на экране
    private class UserAdapter extends RecyclerView.Adapter<UserHolder>{
        ArrayList<User> usersName;
        //создаем конструктор для UserAdapter
        public UserAdapter(ArrayList<User> usersName) {
            this.usersName = usersName;
        }

        //onCreateViewHolder - метод который создает ViewHolder (один элемент списка)
        @Override
        public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //Создание макета списка одного элемента
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            return new UserHolder(inflater, parent);
        }

        // Привязка пользователя к userHolder (аргументы: сам userHolder, позиция в списке)
        @Override
        public void onBindViewHolder(UserHolder userHolder, int position) {
            User user = usersName.get(position);
            // Создаем привязку имени пользователя к элементу списка
            userHolder.bind(user.getUserName()+" "+user.getUserLastname());
        }

        // метод getItemCount, благодаря которому UserAdapter знает кол-во элементов, которое нужно показать на экране
        @Override
        public int getItemCount() {
            return usersName.size();
        }
    }
}