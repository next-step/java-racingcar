package racing.view;

import java.util.Scanner;
import java.util.function.Supplier;

public class InputView {

    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_COUNT_INPUT_MESSAGE = "시도할 회수는 몇 회인가요?";
    private static final String EMPTY_INPUT_MESSAGE = "값을 입력해야 합니다.";
    private static final String INVALID_NUMBER_MESSAGE = "숫자를 입력해야 합니다.";
    private static final String POSITIVE_ONLY_MESSAGE = "양수를 입력해야 합니다.";

    private static final Scanner scanner = new Scanner(System.in);


    public static String readCarNames() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        return readLine();
    }

    public static int readTryCount() {
        System.out.println(TRY_COUNT_INPUT_MESSAGE);
        return readPositiveNumber();
    }

    private static int readPositiveNumber() {
        String input = readLine();
        return parsePositiveNumber(input);
    }

    private static String readLine() {
        String input = scanner.nextLine();

        if (isBlank(input)) {
            throw new RuntimeException(EMPTY_INPUT_MESSAGE);
        }
        return input;
    }

    private static int parsePositiveNumber(String input) {
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
