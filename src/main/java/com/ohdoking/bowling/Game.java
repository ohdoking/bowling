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
        return nextBall() + itsThrows[ball + 1];
    }

    private boolean isStrike() {
        return nextBall() == 10;
    }

    private int handleSecondThrow() {
        int score = 0;
        //spare need score of next first throw
        if (isSpare()){
            ball += 2;
            score += 10 + nextBall();
        }
        else {

            score += twoBallsInFrame();
            ball += 2;
        }
        return score;
    }

    private int nextBall() {
        return itsThrows[ball];
    }

    private boolean isSpare() {
        return nextTwoBalls() == 10;
    }

    private int twoBallsInFrame(){
        return nextBall() + itsThrows[ball + 1];
    }

    public int getCurrentFrame() {
        return this.itsCurrentFrame;
    }
}
