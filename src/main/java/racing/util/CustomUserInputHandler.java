package racing.util;

import java.util.Scanner;

public class CustomUserInputHandler {
    private static Scanner scanner = new Scanner(System.in);

    public static String scan() {
        return scanner.nextLine();
    }

    public static boolean validate(Object userInput) {
        try {
            return (int) userInput > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public static int parseInt(String userInput) {
        return Integer.parseInt(userInput);
    }
}
