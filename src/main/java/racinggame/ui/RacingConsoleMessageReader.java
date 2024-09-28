package racinggame.ui;

import java.io.InputStream;
import java.util.Scanner;

public class RacingConsoleMessageReader implements MessageReader<Integer> {
    private final Scanner scanner;

    public RacingConsoleMessageReader(final InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    @Override
    public Integer read() {
        return scanner.nextInt();
    }
}
