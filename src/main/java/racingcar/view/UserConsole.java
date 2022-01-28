package racingcar.view;

import java.util.Scanner;

public class UserConsole {

    private static Scanner scanner = new Scanner(System.in);

    public static String getConsoleTextFrom(String message) {
        System.out.println(message);
        String line = scanner.nextLine().trim();
        return line;
    }
}
