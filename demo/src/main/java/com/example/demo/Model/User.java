package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

public class User {
    int userId;
    String username;
    String password;
    String first_name;
    String last_name;
    String DOB;
    String nationality;

    public User(
            @JsonProperty("userId") int userId,
            @JsonProperty("username") String username,
            @JsonProperty("password") String password,
            @JsonProperty("first_name") String first_name,
            @JsonProperty("last_name") String last_name,
            @JsonProperty("DOB") String DOB,
            @JsonProperty("nationality") String nationality) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.DOB = DOB;
        this.nationality = nationality;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPassword() {
        return password;
    }
}
