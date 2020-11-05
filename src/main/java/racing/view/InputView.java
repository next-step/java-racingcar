package racing.view;

import java.util.Scanner;

public class InputView {

    private static final String CAR_NAMES_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";

    private static final String ROUND_QUESTION = "시도할 회수는 몇 회 인가요?";

    private static Scanner scanner;

    private InputView() {}

    public static void openScanner() {
        scanner = new Scanner(System.in);
    }

    public static String readCarNames() {
        return read(CAR_NAMES_QUESTION, String.class);
    }

    public static int readRound() {
        return Integer.parseInt(read(ROUND_QUESTION, Integer.class));
    }

    private static <T> String read(final String message, Class<T> clazz) {
        System.out.println(message);

        final String input = scanner.nextLine();

        try {
            InputValidator.validate(input, clazz);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return read(message, clazz);
        }

        return input;
    }

    public static void closeScanner() {
        scanner.close();
    }
}
