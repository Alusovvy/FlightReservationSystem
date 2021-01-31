package com.example.demo.DAO;

import com.example.demo.Model.User;

import java.util.ArrayList;

public interface IUser {
    boolean insertUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(int id);
    User getUser(int id);
    ArrayList<User> getUsers();
}
