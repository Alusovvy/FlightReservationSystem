package com.example.demo.DAO;

import com.example.demo.Model.User;
import org.springframework.stereotype.Repository;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;


@Repository("UserDAO")
public class UserDAO implements IUser {

    public static ConnectionString conStr = new ConnectionString();
    private String connString = conStr.getConnStr();;

    @Override
    public boolean insertUser(User user) {
        try(
                Connection conn = DriverManager.getConnection(
                        connString
                )) {
            String query = "INSERT INTO users (username, password, first_name, last_name, DOB, nationality, age, gender) VALUES (?,?,?,?,?,?,?,?)";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getFirst_name());
            stmt.setString(4, user.getLast_name());
            stmt.setString(5, user.getDOB());
            stmt.setString(6, user.getNationality());
            stmt.setInt(7, user.getAge());
            stmt.setString(8, user.getGender());

            int rows = stmt.executeUpdate();

            if(rows > 0) {
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
        try(
                Connection conn = DriverManager.getConnection(
                        conStr.connStr
                )) {
            String query = "UPDATE users SET username = ?, password = ?, first_name = ?, last_name = ?, DOB = ?, nationality = ?, age = ? , gender = ? WHERE user_id = ?";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getFirst_name());
            stmt.setString(4, user.getLast_name());
            stmt.setString(5, user.getDOB());
            stmt.setString(6, user.getNationality());
            stmt.setInt(7, user.getAge());
            stmt.setString(8, user.getGender());
            stmt.setInt(9, user.getUser_id());

            int rows = stmt.executeUpdate();

            if(rows > 0) {
                return true;
            }

        }


        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }


    @Override
    public boolean deleteUser(int id) {
        try(
                Connection conn = DriverManager.getConnection(
                        conStr.connStr
                )) {
            String query = "DELETE FROM users WHERE user_id = ?";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);

            int rows = stmt.executeUpdate();

            if(rows > 0) {
                return true;
            }

        }


        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    @Override
    public User getUser(int id) {
        User recievedUser = new User(null,null,null,null,null,null,0,null);
        try(
                Connection conn = DriverManager.getConnection(
                        conStr.connStr
                )) {
            String query = "SELECT * FROM users WHERE user_id = ?";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);

            ResultSet result = stmt.executeQuery();
            result.next();
            if (result == null) {
                return null;
            }

                recievedUser.setUser_id(result.getInt("user_id"));
                recievedUser.setUsername(result.getString("username"));
                recievedUser.setPassword(result.getString("password"));
                recievedUser.setFirst_name(result.getString("first_name"));
                recievedUser.setLast_name(result.getString("last_name"));
                recievedUser.setDOB(result.getString("DOB"));
                recievedUser.setAge(result.getInt("age"));
                recievedUser.setNationality(result.getString("nationality"));
                recievedUser.setGender(result.getString("gender"));



        }


        catch (SQLException throwables) {
            throwables.printStackTrace();
        }



        return recievedUser;
    }

    @Override
    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        try(
                Connection conn = DriverManager.getConnection(
                        conStr.connStr
                )) {
            String query = "SELECT * FROM users";

            PreparedStatement stmt = conn.prepareStatement(query);

            ResultSet result = stmt.executeQuery();

            if (result == null) {
                return null;
            }
            while (result.next()) {

                User recievedUser = new User(null, null, null, null, null, null, 0, null);
                recievedUser.setUser_id(result.getInt("user_id"));
                recievedUser.setUsername(result.getString("username"));
                recievedUser.setPassword(result.getString("password"));
                recievedUser.setFirst_name(result.getString("first_name"));
                recievedUser.setLast_name(result.getString("last_name"));
                recievedUser.setDOB(result.getString("DOB"));
                recievedUser.setAge(result.getInt("age"));
                recievedUser.setNationality(result.getString("nationality"));
                recievedUser.setGender(result.getString("gender"));
                users.add(recievedUser);


            }
        }


        catch (SQLException throwables) {
            throwables.printStackTrace();
        }



        return users;
    }
}

