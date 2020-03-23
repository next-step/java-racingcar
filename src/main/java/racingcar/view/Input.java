package racingcar.view;

import java.io.InputStream;
import java.util.Scanner;

public final class Input {
    private final Scanner SCANNER;

    public Input(final InputStream inputStream) {
        SCANNER = new Scanner(inputStream);
    }

    public String read() {
        return SCANNER.nextLine();
    }
}
