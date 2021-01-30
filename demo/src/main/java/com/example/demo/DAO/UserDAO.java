package com.example.demo.DAO;

import com.example.demo.Model.User;
import oracle.jdbc.datasource.OracleDataSource;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


@Repository("UserDAO")
public class UserDAO implements IUser {



    @Override
    public boolean insertUser(User user) {
        try(
                Connection connection = DriverManager.getConnection(
                        "jdbc:oracle:thin:@localhost:1521:XE", "fred", "flintstone"
                )) {
            String query = "INSERT INTO flightapp_users (user_id, username, password, first_name, last_name, DOB, nationallity) VALUES (?,?,?,?,?,?,?)";

            PreparedStatement stmt = connection.prepareStatement(query);

            stmt.setInt(1, user.getUserId());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getFirst_name());
            stmt.setString(5, user.getLast_name());
            stmt.setString(6, user.getDOB());
            stmt.setString(7, user.getNationality());

            if(stmt.execute()) {
                return true;
            }

        }


        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }

    @Override
    public User getUser(User user) {
        return null;
    }

    @Override
    public ArrayList<User> getUsers() {
        return null;
    }
}
