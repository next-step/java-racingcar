package racingcar.view;

import java.io.InputStream;
import java.util.Scanner;

public final class Input {
    private final Scanner SCANNER;
    private static final String EMPTY_STRING = "";

    public Input(final InputStream inputStream) {
        SCANNER = new Scanner(inputStream);
    }

    public String read() {
        String input = SCANNER.nextLine();
        valid(input);
        return input;
    }

    private void valid(final String input) {
        if (input == null || input.trim().equals(EMPTY_STRING)) {
            throw new IllegalArgumentException("올바른 입력값이 아닙니다.");
        }
    }
}
