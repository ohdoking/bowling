package com.ohdoking.bowling;

public class Game {

    private int itsCurrentFrame = 1;
    private boolean firstThrowInFrame = true;
    private Scorer itsScorer = new Scorer();

    public int score() {
        return scoreForFrame(this.itsCurrentFrame);
    }

    public int getCurrentFrame() {
        return this.itsCurrentFrame;
    }

    public void add(int pins) {
        this.itsScorer.addThrow(pins);
        adjustCurrentFrame(pins);
    }

    private void adjustCurrentFrame(int pins) {
        if(isLastBallInFrame(pins)){
            advanceFrame();
        }
        else{
            firstThrowInFrame = false;
        }
    }

    private boolean isLastBallInFrame(int pins) {
        return isStrike(pins) || !firstThrowInFrame;
    }

    private boolean isStrike(int pins) {
        return firstThrowInFrame &&  pins == 10;
    }

    private void advanceFrame() {
        itsCurrentFrame = Math.min(10, itsCurrentFrame + 1);
    }

    public int scoreForFrame(int theFrame) {
        return itsScorer.scoreForFrame(theFrame);
    }

}
