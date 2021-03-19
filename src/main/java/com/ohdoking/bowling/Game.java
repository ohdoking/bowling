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
        if (firstThrowInFrame) {
            if (!adjustFrameForStrike(pins)) {
                firstThrowInFrame = false;
            }
        } else {
            firstThrowInFrame = true;
            advanceFrame();
        }
    }

    private void advanceFrame() {
        itsCurrentFrame = Math.min(10, itsCurrentFrame + 1);
    }

    private boolean adjustFrameForStrike(int pins){
        if (pins == 10) {
            advanceFrame();
            return true;
        }
        return false;
    }

    public int scoreForFrame(int theFrame) {
        return itsScorer.scoreForFrame(theFrame);
    }

}
