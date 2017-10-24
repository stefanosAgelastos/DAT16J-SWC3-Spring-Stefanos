package com.example.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by coag on 24-10-2017.
 */
public class User {
    private final long id;
    private String name;
    private String email;

    private static List<User> userList = new ArrayList<>();

    public User(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public static List<User> getUserList() {
        return userList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
