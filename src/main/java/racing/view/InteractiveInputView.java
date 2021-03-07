package racing.view;

import java.util.Scanner;

public class InteractiveInputView {

    private InteractiveInputView() {
    }

    public static int getInt(String message) {
        printMessage(message);

        return Integer.parseInt(getUserInput());
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

}
