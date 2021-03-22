package chutesladder.rules;

import chutesladder.layout.GameBoardLayout;

public class GameRules {

    public static boolean isTurnOver(int squarePosition, int diceNumber, int nextPosition) {
        boolean isTurnOver = false;
        boolean isPicturePresent = false;
        int intermediateState = squarePosition + diceNumber;
        if (GameBoardLayout.isChute(intermediateState) || GameBoardLayout.isLadder(intermediateState)) {
            isTurnOver = true;
            isPicturePresent = true;
        } else if (GameBoardLayout.isPassThrough(nextPosition)) {
            isTurnOver = true;
        } else if (!isPicturePresent && GameBoardLayout.isArrow(nextPosition)) {
            isTurnOver = true;
        } else if (!isPicturePresent) {
            isTurnOver = true;
        }
        return isTurnOver;
    }
}
