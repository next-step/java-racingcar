package racingcar.ui;

import java.util.Scanner;

public class InputView {
    private final static Scanner scanner = new Scanner(System.in);
    private final static String INPUT_CAR_NUMBER_QUESTION = "자동차 대수는 몇 대 인가요?";
    private final static String INPUT_TRY_NUMBER_QUESTION = "시도할 회수는 몇 회 인가요?";
    private final static String NOT_AN_INTEGER_MESSAGE = "입력하신 값이 정수가 아닙니다.";
    private final static String NOT_A_POSITIVE_NUMBER_MESSAGE = "입력하신 값이 양의 정수가 아닙니다.";

    public static int inputCarNumber() {
        boolean hasValidInput = false;
        Integer input = null;
        while (!hasValidInput) {
            System.out.println(INPUT_CAR_NUMBER_QUESTION);
            input = tryInputNumber();
            hasValidInput = isInputValid(input);
        }
        return input;
    }

    public static int inputTryNumber() {
        boolean hasValidInput = false;
        Integer input = null;
        while (!hasValidInput) {
            System.out.println(INPUT_TRY_NUMBER_QUESTION);
            input = tryInputNumber();
            hasValidInput = isInputValid(input);
        }
        return input;
    }


    private static boolean isInputValid(Integer input) {
        if (input == null) {
            System.out.println(NOT_AN_INTEGER_MESSAGE);
            return false;
        }
        if (input <= 0) {
            System.out.println(NOT_A_POSITIVE_NUMBER_MESSAGE);
            return false;
        }
        return true;
    }

    private static Integer tryInputNumber() {
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            return null;
        }
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public void close() {
        scanner.close();
    }
}
