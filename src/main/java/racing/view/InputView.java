package racing.view;

import java.util.Scanner;
import java.util.regex.Pattern;

import static racing.view.InputValidator.CAR_NAMES_PATTERN;
import static racing.view.InputValidator.ROUND_PATTERN;

public class InputView {

    private static final String CAR_NAMES_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";

    private static final String ROUND_QUESTION = "시도할 회수는 몇 회 인가요?";

    private static Scanner scanner;

    private InputView() {}

    public static void openScanner() {
        scanner = new Scanner(System.in);
    }

    public static String readCarNames() {
        return read(CAR_NAMES_QUESTION, CAR_NAMES_PATTERN);
    }

    public static int readRound() {
        return Integer.parseInt(read(ROUND_QUESTION, ROUND_PATTERN));
    }

    private static <T> String read(final String message, final Pattern pattern) {
        System.out.println(message);

        final String input = scanner.nextLine();

        try {
            InputValidator.validate(input, pattern);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return read(message, pattern);
        }

        return input;
    }

    public static void closeScanner() {
        scanner.close();
    }
}
