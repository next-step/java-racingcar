package racingcar;

import java.util.Scanner;
import java.util.regex.Pattern;

public class MyNumberScanner {
    private static Scanner SCANNER = new Scanner(System.in);
    private static String PATTERN = "^[0-9]*$";

    public static int readInput() {
        String text = SCANNER.nextLine();
        if (!isBlank(text) && isNumber(text)) {
            return toInt(text);
        }
        throw new RuntimeException("양의 정수만 입력하세요.");
    }


    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static boolean isNumber(String text) {
        return Pattern.matches(PATTERN, text);
    }

    private static int toInt(String value) {
        return Integer.parseInt(value);
    }

    private MyNumberScanner() {
    }
}