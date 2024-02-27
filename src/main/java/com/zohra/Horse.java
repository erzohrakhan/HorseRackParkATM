package com.zohra;

public class Horse {
    private String name;
    private int odds;
    private boolean won;

    public Horse(String name, int odds, boolean won) {
        this.name = name;
        this.odds = odds;
        this.won = won;
    }

    public String getName() {
        return name;
    }

    public int getOdds() {
        return odds;
    }

    public boolean hasWon() {
        return won;
    }

    public void setWon(boolean won) {
        this.won = won;
    }
}
