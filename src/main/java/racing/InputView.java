package racing;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int readCarCount() {
        return read("자동차 대수는 몇 대 인가요?");
    }

    public int readRound() {
        return read("시도할 회수는 몇 회 인가요?");
    }

    private int read(final String message) {
        System.out.println(message);

        final String input = scanner.nextLine();
        InputValidator.validate(input);

        return Integer.parseInt(input);
    }

    public void closeScanner() {
        scanner.close();
    }
}
