package chutesladder.actions;

import chutesladder.layout.GameBoardLayout;

public class LadderActionService implements ActionService {

    @Override
    public ActionType getActionName() {
        return ActionType.LADDER;
    }

    @Override
    public int calculateNextPosition(int square, int dice) {
        int nextPosition = square + dice;
        int ladder = GameBoardLayout.getLadderTop(nextPosition);
      //  System.out.print(" Ladder ---> from " + square + " Dice :" + dice + " Ladder :" + ladder);
        return ladder;
    }
}
