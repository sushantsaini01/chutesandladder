package chutesladder;

import chutesladder.game.ChuteAndLadderGame;
import chutesladder.game.Game;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Game game = new ChuteAndLadderGame();
        game.play();

    }
}
