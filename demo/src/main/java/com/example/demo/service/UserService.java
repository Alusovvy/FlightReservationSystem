package com.example.demo.service;

import com.example.demo.DAO.IUser;
import com.example.demo.DAO.UserDAO;
import com.example.demo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    private final UserDAO userDAO;

    public UserService(@Qualifier("UserDAO") UserDAO userDao) {
        this.userDAO = userDao;
    }


    public boolean insertUser(User user) {
        return userDAO.insertUser(user);
    }

    public boolean updateUser(User user) {
        return false;
    }

    public boolean deleteUser(int id) {
        return false;
    }

    public User getUser(User user) {
        return null;
    }

    public ArrayList<User> getUsers() {
        return null;
    }
}
