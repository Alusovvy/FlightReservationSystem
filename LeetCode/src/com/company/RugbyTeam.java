package com.company;

public class RugbyTeam extends Team{
    private int rank;
    public RugbyTeam(String name, int points) {
        super(name);
        this.rank = points;
    }


    public int getRank() {
        return rank;
    }
}
