package chutesladder.game;

import chutesladder.actions.ActionDecider;
import chutesladder.actions.ActionService;
import chutesladder.actions.ActionType;
import chutesladder.enrollment.Enrollment;
import chutesladder.entities.Player;
import chutesladder.layout.GameBoardLayout;
import chutesladder.output.ApplicationConstants;
import chutesladder.output.ConsoleOutput;
import chutesladder.rules.Dice;
import chutesladder.rules.GameRules;
import chutesladder.rules.PlayerQueue;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ChuteAndLadderGame extends Game {

    private List<Player> playerList;
    private PlayerQueue playerQueue;
    private ActionDecider actionDecider = new ActionDecider();
    private Player winner;
    int counter=1;

    void initialize() {
        this.playerList = Enrollment.enrollPlayers();
        GameBoardLayout.loader();
    }

    void firstSpin() {
        for (Player player : this.playerList) {
            int value = Dice.getDiceNumber();
            //System.out.println(player.getName() + "  value " + value);
            player.setCurrentPosition(value);
        }
        this.playerList.stream()
                       .sorted(Comparator.comparingInt(Player::getCurrentPosition))
                       .collect(Collectors.toList());

        this.playerQueue = new PlayerQueue();
        this.playerList.forEach(
            player -> {
                player.setCurrentPosition(0);
                this.playerQueue.addPlayer(player);
            }
                               );
    }

    void startPlay() {
        Player current = this.playerQueue.getFirstElement();

        do {
            int diceNumber = Dice.getDiceNumber();
            ActionService actionService = actionDecider.getAction(current.getCurrentPosition(), diceNumber);
            int calculatedMove = actionService.calculateNextPosition(current.getCurrentPosition(), diceNumber);

            int beforeMove = current.getCurrentPosition();
            current.setCurrentPosition(calculatedMove);

            //game output start
            if(actionService.getActionName().equals(ActionType.DEFAULT)) {
                System.out.println(counter++ + ":" + " " +current.getName() + ": " + beforeMove + " --> " +current.getCurrentPosition());
            }else {
                int number = beforeMove+diceNumber;
                System.out.println(counter++ + ":" + " " +current.getName() + ": " + beforeMove + " --> " + number +" --" + actionService.getActionName() + "-->" + " " +current.getCurrentPosition());
            }
            //game output end

            if (GameBoardLayout.isWinner(current.getCurrentPosition())) {
                this.winner = current;
                break;
            }
            if (GameRules.isTurnOver(beforeMove, diceNumber, current.getCurrentPosition())) {
                current = this.playerQueue.getNextPlayer(current);
            }

            //Thread.sleep(3000);
        } while (true);
    }

    //end game winner output
    void endPlay() {
        ConsoleOutput.displayMessage(ApplicationConstants.WINNER_MESSAGE +winner.getName() +ApplicationConstants.WINNTER_SPECIAL_CHAR);
    }

}
