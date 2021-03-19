package com.ohdoking.bowling;

public class Game {

    private int itsScore = 0;

    private int itsCurrentFrame = 1;
    private boolean firstThrowInFrame = true;
    private Scorer itsScorer = new Scorer();

    public int score() {
        return scoreForFrame(getCurrentFrame() - 1);
    }

    public int getCurrentFrame() {
        return this.itsCurrentFrame;
    }

    public void add(int pins) {
        this.itsScorer.addThrow(pins);
        this.itsScore += pins;
        adjustCurrentFrame(pins);
    }

    private void adjustCurrentFrame(int pins) {
        if (firstThrowInFrame) {
            // strike
            if (pins == 10) {
                itsCurrentFrame++;
            } else {
                firstThrowInFrame = false;
            }
        } else {
            firstThrowInFrame = true;
            this.itsCurrentFrame++;
        }
        itsCurrentFrame = Math.min(11, itsCurrentFrame);
    }


    public int scoreForFrame(int theFrame) {
        return itsScorer.scoreForFrame(theFrame);
    }

}
