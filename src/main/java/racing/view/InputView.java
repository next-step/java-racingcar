package racing.view;

import java.util.Scanner;

public class InputView {

    private static final String CAR_COUNT_QUESTION = "자동차 대수는 몇 대 인가요?";

    private static final String ROUND_QUESTION = "시도할 회수는 몇 회 인가요?";

    private static Scanner scanner;

    private InputView() {}

    public static void openScanner() {
        scanner = new Scanner(System.in);
    }

    public static int readCarCount() {
        return read(CAR_COUNT_QUESTION);
    }

    public static int readRound() {
        return read(ROUND_QUESTION);
    }

    private static int read(final String message) {
        System.out.println(message);

        final String input = scanner.nextLine();

        try {
            InputValidator.validate(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return read(message);
        }

        return Integer.parseInt(input);
    }

    public static void closeScanner() {
        scanner.close();
    }
}
