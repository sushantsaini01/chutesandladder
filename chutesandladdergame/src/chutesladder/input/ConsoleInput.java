package chutesladder.input;

import chutesladder.entities.Player;
import chutesladder.exceptions.OverAgeRestriction;
import chutesladder.exceptions.UnderAgeRestriction;
import chutesladder.output.ApplicationConstants;
import chutesladder.output.ConsoleOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ConsoleInput implements Input {
//this class will do player validation and then add the player in the queue.
    private List<Player> players =new ArrayList<>();

    @Override
    public List<Player> addPlayer() {
        try (
            Scanner scanner = new Scanner(System.in)) {
            ConsoleOutput.displayMessage(ApplicationConstants.INPUT_PROMPT_1);
            while (scanner.hasNextLine()) {
                Player p = createPlayer(scanner.nextLine().split(ApplicationConstants.INPUT_STRING_SPLITTER_REGEX));
                if (p != null && players.size()<ApplicationConstants.MAX_NO_OF_PLAYER) {
                    players.add(p);
                    ConsoleOutput.displayMessage(ApplicationConstants.PLAYERS_ADDED_STATEMENT);
                    ConsoleOutput.displayMessage(ApplicationConstants.INPUT_PROMPT_2);
                    if ("N".equalsIgnoreCase(scanner.nextLine()) && validateMinNumberOfPlayers(players)) {
                        break;
                    }
                    ConsoleOutput.displayMessage(ApplicationConstants.INPUT_PROMPT_1);
                } else if (players.size()>=ApplicationConstants.MAX_NO_OF_PLAYER){
                    ConsoleOutput.displayMessage(ApplicationConstants.MORE_NUMBER_OF_PLAYERS_RESTRICTION);
                    ConsoleOutput.displayMessage(ApplicationConstants.INPUT_PROMPT_3);
                    if ("N".equalsIgnoreCase(scanner.nextLine())){
                        System.exit(0);
                    } else {
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return players;
    }

    private static boolean validateMinNumberOfPlayers(List<Player> players) {
        boolean validateMinNumberOfPlayers = false;
        if (players.size() < 2) {
            ConsoleOutput.displayMessage(ApplicationConstants.LESS_NUMBER_OF_PLAYERS_RESTRICTION);
            return validateMinNumberOfPlayers;
        } else {
            return validateMinNumberOfPlayers = true;
        }
    }

    private static Player createPlayer(String[] playerInfo) {
        Player player = null;
        try {
            player = new Player(playerInfo[0], Integer.parseInt(playerInfo[1]));
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            ConsoleOutput.displayMessage(ApplicationConstants.PLAYER_ADDED_EXCEPTION);
            ConsoleOutput.displayMessage(ApplicationConstants.INPUT_PROMPT_1);
        } catch (NumberFormatException numberFormatException) {
            ConsoleOutput.displayMessageWithObj(ApplicationConstants.NUMBER_FORMAT_EXCEPTION, playerInfo[1]);
            ConsoleOutput.displayMessage(ApplicationConstants.INPUT_PROMPT_1);
        } catch (UnderAgeRestriction underAgePlayerException) {
            ConsoleOutput.displayMessage(ApplicationConstants.PLAYER_CANNOT_ADD_MESSAGE+underAgePlayerException.getMessage());
            ConsoleOutput.displayMessage(ApplicationConstants.INPUT_PROMPT_1);
        } catch (OverAgeRestriction overAgePlayerException) {
            ConsoleOutput.displayMessage(ApplicationConstants.PLAYER_CANNOT_ADD_MESSAGE+overAgePlayerException.getMessage());
            ConsoleOutput.displayMessage(ApplicationConstants.INPUT_PROMPT_1);
        }
        return player;
    }
}
