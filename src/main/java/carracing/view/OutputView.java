package carracing.view;

import carracing.domain.Renderable;

import java.io.PrintStream;

public class OutputView {

    private static final String CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String MOVE_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";

    private final PrintStream printStream;

    private OutputView(PrintStream printStream) {
        this.printStream = printStream;
    }

    public static OutputView of(PrintStream printStream) {
        return new OutputView(printStream);
    }

    public void printInputCarCountMessage() {
        printStream.println(CAR_COUNT_MESSAGE);
    }

    public void printInputMoveCountMessage() {
        printStream.println(MOVE_COUNT_MESSAGE);
    }

    public void printResultMessage() {
        printStream.println(RESULT_MESSAGE);
    }

    public void printNewLine() {
        printStream.println();
    }

    public void print(Renderable renderable) {
        printStream.println(renderable.render());
    }
}
