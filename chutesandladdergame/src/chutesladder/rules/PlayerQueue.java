package chutesladder.rules;

import chutesladder.entities.Player;
import java.util.LinkedList;
import java.util.Queue;

public class PlayerQueue {

    Queue<Player> queue
        = new LinkedList<>();

    public Player getNextPlayer(Player currentPlayer) {
        queue.add(currentPlayer);
        return queue.poll();
    }

    public void addPlayer(Player player) {
        queue.add(player);
    }

    public Player getFirstElement() {
        return queue.poll();
    }

}
