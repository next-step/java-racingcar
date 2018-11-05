package racing_game;

import java.io.PrintStream;

public class ResultPrinter implements AutoCloseable {

    private static final String CAR_SHAPE ="-";

    private final PrintStream printStream;

    public ResultPrinter(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void print(int moveCount) {
        StringBuilder stringBuilder = new StringBuilder(moveCount);
        for (int i = 0; i < moveCount; i++) {
            stringBuilder.append(CAR_SHAPE);
        }
        this.printStream.println(stringBuilder.toString());
    }

    @Override
    public void close() {
        this.printStream.close();
    }
}
