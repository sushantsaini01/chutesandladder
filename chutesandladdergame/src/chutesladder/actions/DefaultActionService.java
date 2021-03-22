package chutesladder.actions;

public class DefaultActionService implements ActionService {

    @Override
    public ActionType getActionName() {
        return ActionType.DEFAULT;
    }

    @Override
    public int calculateNextPosition(int square, int dice) {
        return square + dice;
    }
}
