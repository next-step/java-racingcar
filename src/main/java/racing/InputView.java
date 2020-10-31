package racing;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner;

    private InputView() {}

    public static void openScanner() {
        scanner = new Scanner(System.in);
    }

    public static int readCarCount() {
        return read("자동차 대수는 몇 대 인가요?");
    }

    public static int readRound() {
        return read("시도할 회수는 몇 회 인가요?");
    }

    private static int read(final String message) {
        System.out.println(message);

        final String input = scanner.nextLine();
        InputValidator.validate(input);

        return Integer.parseInt(input);
    }

    public static void closeScanner() {
        scanner.close();
    }
}
