package com.ohdoking.bowling;

public class Game {

    private int itsScore = 0;
    private int itsCurrentThrow = 0;
    private int[] itsThrows = new int[21];

    public void add(int pins) {
        itsThrows[itsCurrentThrow++] = pins;
        this.itsScore += pins;
    }

    public int score() {
        return this.itsScore;
    }

    public int scoreForFrame(int theFrame) {
        int score = 0;
        int ball = 0;

        for(int currentFrame = 0; currentFrame < theFrame; currentFrame++){
            int firstThrow = itsThrows[ball++];
            int secondThrow = itsThrows[ball++];
            int frameScore = firstThrow + secondThrow;
            //spare need score of next first throw
            if (frameScore == 10){
                score += frameScore + itsThrows[ball++];
            }
            else {
                score += frameScore;
            }

        }
        return score;
    }
}
