package chutesladder.actions;

import chutesladder.layout.GameBoardLayout;
import java.util.HashSet;
import java.util.Set;

public class ActionDecider {
//decide the strategy that needs to be invoked based on the condition.
    ActionStrategy strategy = null;

    public ActionDecider() {
        //To:Do
        Set<ActionService> actionSet = new HashSet<>();
        actionSet.add(new ChuteActionService());
        actionSet.add(new LadderActionService());
        actionSet.add(new WinnerWaitActionService());
        actionSet.add(new DefaultActionService());
        this.strategy = new ActionStrategy(actionSet);


    }

    public ActionService getAction(int diceNumber, int squarelocation) {
        int nextNumber = diceNumber + squarelocation;
        if (!GameBoardLayout.isValidMove(nextNumber)) {
            return strategy.findAction(ActionType.WINNERWAIT);
        } else if (GameBoardLayout.isLadder(nextNumber)) {
            return strategy.findAction(ActionType.LADDER);
        } else if (GameBoardLayout.isChute(nextNumber)) {
            return strategy.findAction(ActionType.CHUTE);
        }
        else {
            return strategy.findAction(ActionType.DEFAULT);
        }
    }
}
