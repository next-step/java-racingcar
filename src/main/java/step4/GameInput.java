package step4;

import java.util.Scanner;

public class GameInput {

    static Scanner scanner = new Scanner(System.in);

    public static int readRoundCount() {
        int roundCount = scanner.nextInt();
        validateRoundCount(roundCount);
        return roundCount;
    }

    private static void validateRoundCount(int roundCount) {
        if (roundCount <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public static String[] readCarNames() {
        String names = scanner.nextLine();
        validateNames(names);
        return names.split(",");
    }

    private static void validateNames(String names) {
        if (names.length() == 0) {
            throw new IllegalArgumentException();
        }
    }
}
