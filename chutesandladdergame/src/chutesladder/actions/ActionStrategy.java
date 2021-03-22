package chutesladder.actions;

import java.util.EnumMap;
import java.util.Set;

public class ActionStrategy {
//map the enum and strategy objects in enum map and then get the respective strategy instance from get method
    EnumMap<ActionType, ActionService> actions;

    public ActionStrategy(Set<ActionService> actionSet) {
        createActions(actionSet);
    }

    private void createActions(Set<ActionService> actionSet) {
        this.actions = new EnumMap(ActionType.class);
        actionSet.forEach(
            act -> actions.put(act.getActionName(), act));
    }

    public ActionService findAction(ActionType actionType) {
        return this.actions.get(actionType);
    }
}
