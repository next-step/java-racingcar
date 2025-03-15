package step3;

import java.util.Scanner;

public class RacingCarGame {

    public static String inputUsers() {
        return getInput();
    }

    public static String inputMovements() {
        return getInput();
    }

    private static String getInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        return input;
    }
}
