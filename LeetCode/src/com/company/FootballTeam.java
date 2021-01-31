package com.company;

public class FootballTeam extends Team{

    private int rank;

    public FootballTeam(String name, int points) {
        super(name);
        this.rank = points;
    }





    public int getRank() {
        return rank;
    }
}
