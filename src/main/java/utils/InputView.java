package utils;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputCarCount() {
        return toInt(inputNextLine());
    }

    private static String inputNextLine() {
        return scanner.nextLine();
    }

    private static int toInt(String number) {
        return Integer.parseInt(number);
    }
}
