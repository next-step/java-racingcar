package carracing.view;

import java.io.PrintStream;
import java.util.Objects;

public class OutputView {

    private static final String MOVE_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";

    private final PrintStream printStream;

    private OutputView(PrintStream printStream) {
        this.printStream = printStream;
    }

    public static OutputView of(PrintStream printStream) {
        return new OutputView(printStream);
    }

    public void printInputMoveCountMessage() {
        printStream.println(MOVE_COUNT_MESSAGE);
    }

    public void printResultMessage() {
        printStream.println(RESULT_MESSAGE);
    }

    public void printPosition(PositionRenderer positionRenderer) {
        printStream.println(Objects.requireNonNull(positionRenderer).render());
    }
}
