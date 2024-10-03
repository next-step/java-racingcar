package racinggame.ui;

import java.io.InputStream;
import java.util.Scanner;

public class RacingGameMessageReader implements MessageReader {
    private final Scanner scanner;

    public RacingGameMessageReader(final InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    @Override
    public int readInt() {
        return scanner.nextInt();
    }

    @Override
    public String readString() {
        return scanner.nextLine();
    }
}
