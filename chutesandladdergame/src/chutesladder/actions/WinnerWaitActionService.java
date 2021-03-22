package chutesladder.actions;

public class WinnerWaitActionService implements ActionService {

    @Override
    public ActionType getActionName() {
        return ActionType.WINNERWAIT;
    }

    @Override
    public int calculateNextPosition(int square, int dice) {
        System.out.println("Player waiting for correct digit : " + square);
        return square;
    }
}
