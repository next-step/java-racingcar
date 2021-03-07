package racing.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InteractiveInputView {

    private InteractiveInputView() {
    }

    public static int getInt(String message) {
        printMessage(message);

        return Integer.parseInt(getUserInput());
    }

    public static List<String> getListOfString(String message, String delimiter) {
        printMessage(message);

        return Arrays.asList(getUserInput().split(delimiter)
                                           .clone());
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

}
