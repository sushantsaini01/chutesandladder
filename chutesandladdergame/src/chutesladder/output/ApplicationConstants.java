package chutesladder.output;

public class ApplicationConstants {

    public static final String INPUT_PROMPT_1 = "Please enter player name and age delimited by comma i.e Sushant,5 : ";
    public static final String INPUT_PROMPT_2 = "Do you want to add another player[Y]? Type 'N' and press enter to start the game.";
    public static final String INPUT_PROMPT_3 = "Do you want to begin the game ? If yes then enter any key and press enter otherwise enter 'N' to end the game.";
    public static final String PLAYERS_ADDED_STATEMENT = "The player has been added successfully.";
    public static final String INVALID_INPUT = "Please enter a valid input.";
    public static final String INPUT_STRING_SPLITTER_REGEX = ",";
    public static final String WINNTER_SPECIAL_CHAR = "!";
    public static final String WINNER_MESSAGE = "The winner is ";

    //Max number of player allowed to enter value
    public static final int MAX_NO_OF_PLAYER = 4;

    //ERROR Messages
    public static final String PLAYER_ADDED_EXCEPTION = "ERROR : Player cannot be added. Please enter valid player input.";
    public static final String NUMBER_FORMAT_EXCEPTION = "ERROR : Player cannot be added. Please enter valid age between 4 an7 years. ";
    public static final String PLAYER_CANNOT_ADD_MESSAGE = "ERROR : Player cannot be added. ";
    public static final String PLAYER_AGE_RESTRICTION = "ERROR : This game is for players between age 4 and 7 years. Please enter a valid age as the age you entered is not vaid : ";
    public static final String MORE_NUMBER_OF_PLAYERS_RESTRICTION = "WARNING : You have reached to the maximum number of players capacity for this game i.e 4. This game is for 2 to 4 payers.";
    public static final String LESS_NUMBER_OF_PLAYERS_RESTRICTION = "ERROR : The number of players entered is less than 2. This game is for 2 to 4 payers. Please enroll valid number of players.";
}
