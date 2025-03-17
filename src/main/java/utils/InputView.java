package utils;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회 인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputCarCount() {
        println(INPUT_CAR_COUNT_MESSAGE);
        return toInt(inputNextLine());
    }

    public static int inputTryCount() {
        println(INPUT_TRY_COUNT_MESSAGE);
        return toInt(inputNextLine());
    }

    private static String inputNextLine() {
        return scanner.nextLine();
    }

    private static int toInt(String number) {
        return Integer.parseInt(number);
    }

    private static void println(String message) {
        System.out.println(message);
    }
}
