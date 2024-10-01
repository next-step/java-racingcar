package racingcar;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);
    private static String INPUT_CAR_NUMBER_QUESTION = "자동차 대수는 몇 대 인가요?";
    private static String INPUT_TRY_NUMBER_QUESTION = "자동차 대수는 몇 대 인가요?";
    private static String NOT_AN_INTEGER_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static String NOT_A_POSITIVE_NUMBER_MESSAGE = "자동차 대수는 몇 대 인가요?";

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
        if (input != null) {
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
