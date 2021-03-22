package chutesladder.enrollment;

import chutesladder.entities.Player;
import chutesladder.input.ConsoleInput;
import chutesladder.input.Input;
import java.util.List;

public class Enrollment {

    public static List<Player> enrollPlayers() {
        Input input = new ConsoleInput();
        return input.addPlayer();
    }
}
