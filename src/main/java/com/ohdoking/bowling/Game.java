package com.ohdoking.bowling;

public class Game {

    private int itsScore = 0;
    private int itsCurrentThrow = 0;
    private int[] itsThrows = new int[21];
    private int itsCurrentFrame = 1;
    private boolean firstThrowInFrame = true;

    private int ball;

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
            if (isStrike()){
                score += 10 + nextTwoBallsForStrike();
                ball++;
            } else if(isSpare()){
                score += 10 + nextBallForSpare();
                ball += 2;
            }
            else{
                score += twoBallsInFrame();
                ball += 2;
            }
        }
        return score;
    }

    private int nextTwoBallsForStrike() {
        return itsThrows[ball + 1] + itsThrows[ball + 2];
    }

    private boolean isStrike() {
        return itsThrows[ball] == 10;
    }

    private int nextBallForSpare() {
        return itsThrows[ball + 2];
    }

    private boolean isSpare() {
        return (itsThrows[ball] + itsThrows[ball + 1]) == 10;
    }

    private int twoBallsInFrame(){
        return itsThrows[ball] + itsThrows[ball + 1];
    }

    public int getCurrentFrame() {
        return this.itsCurrentFrame;
    }
}
