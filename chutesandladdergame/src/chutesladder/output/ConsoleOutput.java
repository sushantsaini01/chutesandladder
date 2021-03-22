package chutesladder.output;

public class ConsoleOutput {


    public static void displayMessage(String message) {
        System.out.println(message);
    }

    public static void displayMessageWithObj(String message, Object... args) {
        System.out.println(String.format(message, args));
    }
}
