package com.ohdoking.bowling;

public class Frame {

    private int itsScore = 0;

    public int getScore() {
        return this.itsScore;
    }

    public void add(int pins) {
        this.itsScore += pins;
    }
}
