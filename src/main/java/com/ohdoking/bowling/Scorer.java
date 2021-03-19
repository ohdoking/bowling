package com.ohdoking.bowling;

public class Scorer {
    private int ball;
    private int itsCurrentThrow = 0;
    private int[] itsThrows = new int[21];

    public void addThrow(int pins) {
        itsThrows[itsCurrentThrow++] = pins;
    }

    public int scoreForFrame(int theFrame) {
        int score = 0;
        ball = 0;

        for (int currentFrame = 0; currentFrame < theFrame; currentFrame++) {
            if (isStrike()) {
                score += 10 + nextTwoBallsForStrike();
                ball++;
            } else if (isSpare()) {
                score += 10 + nextBallForSpare();
                ball += 2;
            } else {
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

    private int twoBallsInFrame() {
        return itsThrows[ball] + itsThrows[ball + 1];
    }


}
