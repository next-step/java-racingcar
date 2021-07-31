package carracing.view;

import carracing.domain.Position;
import carracing.domain.Positions;

import java.io.PrintStream;
import java.util.Collections;

public class OutputView {

    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String MOVE_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String POSITION_RENDER_DELIMITER = "";
    private static final String POSITION_EXPRESSION = "-";

    private final PrintStream printStream;

    private OutputView(PrintStream printStream) {
        this.printStream = printStream;
    }

    public static OutputView of(PrintStream printStream) {
        return new OutputView(printStream);
    }

    public void printCarNameInputMessage() {
        printStream.println(CAR_NAME_INPUT_MESSAGE);
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

    public void print(Positions positions) {
        positions.forEach(this::print);
    }

    public void print(Position position) {
        printStream.println(String.join(POSITION_RENDER_DELIMITER, Collections.nCopies(position.getValue(), POSITION_EXPRESSION)));
    }

}
