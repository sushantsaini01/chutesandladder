package chutesladder.actions;

public interface ActionService {

    ActionType getActionName();

    int calculateNextPosition(int square, int dice);

}
