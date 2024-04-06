package com.example.blogApi.examples;

import com.example.blogApi.entities.User;
import com.example.blogApi.repo.UserRepo;
import com.example.blogApi.service.UserService;
import com.example.blogApi.utils.Datasource;

import java.util.List;

public class UserServiceExample {
    public static void main(String[] args) {
        createUserExample();
        listUserExample();
        getUserExample();
        getUserName();
    }

    public static void createUserExample() {
        System.out.println("User create example");
        Datasource datasource = new Datasource();
        UserRepo userRepo = new UserRepo(datasource);
        UserService userService = new UserService(userRepo);

        User user=new User();
        user.setUserName("Bhawana");
        user.setEmail("bhawana@gmail.com");
        user.setPassword("bhawana123");

        User addedUser=userService.addUser(user);


        System.out.println("User created: " + addedUser);
    }

    public static void listUserExample() {
        System.out.println("List User Example");
        Datasource datasource = new Datasource();
        UserRepo userRepo = new UserRepo(datasource);
        UserService userService = new UserService(userRepo);
        List<User> userList = userService.listUser();

        System.out.println("user List:" + userList);
    }
    public static void getUserExample() {
        System.out.println("User get example");
        Datasource datasource = new Datasource();
        UserRepo userRepo = new UserRepo(datasource);
        UserService userService =new UserService(userRepo);
        User user = userService.getUserByEmail("aisha60@gmail.com");
        System.out.println("User:" + user);
    }
    public static void getUserName() {
        System.out.println("User get example");
        Datasource datasource = new Datasource();
        UserRepo userRepo = new UserRepo(datasource);
        UserService userService =new UserService(userRepo);
        User user = userService.getUserByUserName("aisha");
        System.out.println("Username:" + user);
    }

}
