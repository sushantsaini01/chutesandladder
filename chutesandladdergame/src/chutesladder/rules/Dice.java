package chutesladder.rules;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    public static int getDiceNumber() {
        return ThreadLocalRandom.current()
                                .nextInt(1, 7);
    }
}
