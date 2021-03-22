package chutesladder.actions;

import chutesladder.layout.GameBoardLayout;

public class ChuteActionService implements ActionService {

    @Override
    public ActionType getActionName() {
        return ActionType.CHUTE;
    }

    @Override
    public int calculateNextPosition(int square, int dice) {
        int nextPosition = square + dice;
        int chute = GameBoardLayout.getChuteTrail(nextPosition);
        //System.out.println("chute ---> from " + square + " Dice :" + dice + " chute :" + chute);
        return chute;
    }
}
