package racingcar.utils;

import java.util.Scanner;

public final class InputUtils {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputUtils() {
    }

    public static String inputString(String message) {
        System.out.println(message);
        return SCANNER.nextLine();
    }

    public static Integer inputInt(String message) {
        System.out.println(message);
        return SCANNER.nextInt();
    }
}
