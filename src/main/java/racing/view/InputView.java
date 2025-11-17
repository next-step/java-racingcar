package racing.view;

import java.util.Scanner;

public class InputView {

    private static final String CAR_COUNT_INPUT_MESSAGE = "자동차 대수는 몇 대인가요?";
    private static final String TRY_COUNT_INPUT_MESSAGE = "시도할 회수는 몇 회인가요?";
    private static final String EMPTY_INPUT_MESSAGE = "값을 입력해야 합니다.";
    private static final String INVALID_NUMBER_MESSAGE = "숫자를 입력해야 합니다.";
    private static final String POSITIVE_ONLY_MESSAGE = "양수를 입력해야 합니다.";

    private static final Scanner scanner = new Scanner(System.in);

    public static int readCarCount() {
        return readPositiveNumber(CAR_COUNT_INPUT_MESSAGE);
    }

    public static int readTryCount() {
        return readPositiveNumber(TRY_COUNT_INPUT_MESSAGE);
    }

    private static int readPositiveNumber(String message) {
        String input = readLine(message);
        return parsePositiveNumber(input);
    }

    private static String readLine(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    private static int parsePositiveNumber(String input) {
        if (isBlank(input)) {
            throw new RuntimeException(EMPTY_INPUT_MESSAGE);
        }

        try {
            int number = Integer.parseInt(input);
            validatePositive(number);
            return number;
        } catch (NumberFormatException e) {
            throw new RuntimeException(INVALID_NUMBER_MESSAGE);
        }
    }

    private static void validatePositive(int number) {
        if (number <= 0) {
            throw new RuntimeException(POSITIVE_ONLY_MESSAGE);
        }
    }

    private static boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }
}
