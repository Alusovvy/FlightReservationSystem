package com.company;

import java.util.ArrayList;

public class League<T extends Team> {

    ArrayList<T> teams = new ArrayList<>();

    public boolean addTeam(T team) {
        if (!teams.contains(team)) {
            teams.add(team);
            return true;
        }
        else {
            System.out.println("Team already in the league");
            return false;
        }
    }
}
