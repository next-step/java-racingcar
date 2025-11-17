package racing.view;

import java.util.Scanner;
import java.util.function.Supplier;

public class InputView {

    private static final String CAR_COUNT_INPUT_MESSAGE = "자동차 대수는 몇 대인가요?";
    private static final String TRY_COUNT_INPUT_MESSAGE = "시도할 회수는 몇 회인가요?";
    private static final String EMPTY_INPUT_MESSAGE = "값을 입력해야 합니다.";
    private static final String INVALID_NUMBER_MESSAGE = "숫자를 입력해야 합니다.";
    private static final String POSITIVE_ONLY_MESSAGE = "양수를 입력해야 합니다.";

    private static final Scanner scanner = new Scanner(System.in);

    public static int readCarCount() {
        System.out.println(CAR_COUNT_INPUT_MESSAGE);
        return repeatUntilReadValidInput(InputView::readPositiveNumber);
    }

    public static int readTryCount() {
        System.out.println(TRY_COUNT_INPUT_MESSAGE);
        return repeatUntilReadValidInput(InputView::readPositiveNumber);
    }

    private static int readPositiveNumber() {
        String input = readLine();
        return parsePositiveNumber(input);
    }

    private static String readLine() {
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

    private static <T> T repeatUntilReadValidInput(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (RuntimeException exception) {
                System.out.println(exception.getMessage());;
            }
        }
    }
}
