package utils;

import java.util.*;

public class CustomScanner {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> scanInputCarNames() {
        String inputLine = scanner.nextLine();

        if (inputLine.isEmpty()) {
            return Collections.emptyList();
        }
        return Arrays.asList(inputLine.split(","));
    }

    public static int scanMoveCount() {
        return scanner.nextInt();
    }
}
