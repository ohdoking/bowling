package com.ohdoking.bowling;

public class Game {

    private int itsScore = 0;

    public void add(int pins) {
        this.itsScore += pins;
    }

    public int score() {
        return this.itsScore;
    }
}
