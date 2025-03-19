package utils;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회 인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    public static String[] inputCarNames() {
        println(INPUT_CAR_NAMES_MESSAGE);
        return splitCarNames(inputNextLine());
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

    private static String[] splitCarNames(String inputNames) {
        return inputNames.split(",");
    }

    private static void println(String message) {
        System.out.println(message);
    }
}
