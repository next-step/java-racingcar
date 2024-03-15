package game.view;

import java.util.List;

public class ResultView {

    public static void printPlainMessage(final String message) {
        System.out.println(message);
    }

    public static void printPlainMessages(final List<String> messages) {
        for (String message : messages) {
            printPlainMessage(message);
        }
        printPlainMessage("");
    }
}
