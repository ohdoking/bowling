package com.ohdoking.bowling;

public class Game {

    private int itsScore = 0;
    private int itsCurrentThrow = 0;
    private int[] itsThrows = new int[21];
    private int itsCurrentFrame = 1;
    private boolean firstThrowInFrame = true;

    private int ball;
    private int firstThrow;
    private int secondThrow;

    public void add(int pins) {
        itsThrows[itsCurrentThrow++] = pins;
        this.itsScore += pins;
        adjustCurrentFrame(pins);
    }

    private void adjustCurrentFrame(int pins) {
        if (firstThrowInFrame){
            // strike
            if(pins == 10) {
                itsCurrentFrame++;
            }
            else{
                firstThrowInFrame = false;
            }
        }
        else{
            firstThrowInFrame = true;
            this.itsCurrentFrame++;
        }
        itsCurrentFrame = Math.min(11, itsCurrentFrame);
    }

    public int score() {
        return scoreForFrame(getCurrentFrame() - 1);
    }

    public int scoreForFrame(int theFrame) {
        int score = 0;
        ball = 0;

        for(int currentFrame = 0; currentFrame < theFrame; currentFrame++){
            firstThrow = itsThrows[ball];
            if (isStrike()){
                ball++;
                score += 10 + nextTwoBalls();
            }
            else{
                score += handleSecondThrow();
            }
        }
        return score;
    }

    private int nextTwoBalls() {
        return itsThrows[ball] + itsThrows[ball + 1];
    }

    private boolean isStrike() {
        return itsThrows[ball] == 10;
    }

    private int handleSecondThrow() {
        int score = 0;
        secondThrow = itsThrows[ball + 1];

        int frameScore = firstThrow + secondThrow;
        //spare need score of next first throw
        if (frameScore == 10){
            ball += 2;
            score += frameScore + itsThrows[ball];
        }
        else {
            ball += 2;
            score += frameScore;
        }
        return score;
    }

    public int getCurrentFrame() {
        return this.itsCurrentFrame;
    }
}
