package chutesladder.entities;


import chutesladder.exceptions.OverAgeRestriction;
import chutesladder.exceptions.UnderAgeRestriction;
import chutesladder.output.ApplicationConstants;
import chutesladder.output.ConsoleOutput;

public class PlayerValidation {

    public static void verifyPlayer(int age) throws OverAgeRestriction, UnderAgeRestriction {
        if (age < 4) {
            throw new UnderAgeRestriction(ApplicationConstants.PLAYER_AGE_RESTRICTION + age);
        } else if (age > 7) {
            throw new OverAgeRestriction(ApplicationConstants.PLAYER_AGE_RESTRICTION + age);
        }
    }
}

