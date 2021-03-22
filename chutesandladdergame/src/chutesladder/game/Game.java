package chutesladder.game;

public abstract class Game {

    abstract void initialize();

    abstract void firstSpin();

    abstract void startPlay();

    abstract void endPlay();


    public final void play() {

        //initialize the game
        initialize();

        //spin the spinner to sort who will play first
        firstSpin();

        //start game
        startPlay();

        //end game
        endPlay();
    }
}
