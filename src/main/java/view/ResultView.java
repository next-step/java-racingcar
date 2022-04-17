package view;

import domain.Positions;

import java.util.List;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String POSITION_BAR = "-";
    private static final String NEW_LINE = "\n";
    private static final ResultView resultView = new ResultView();

    private ResultView() {
    }

    public static ResultView getInstance() {
        return resultView;
    }

    public void printResult(List<Positions> positionsList) {
        System.out.println(RESULT_MESSAGE);
        for (Positions positions : positionsList) {
            printEachAttempt(positions);
            System.out.println();
        }
        System.out.print(NEW_LINE);
    }

    private void printEachAttempt(Positions positions) {
        positions.getPositions().forEach(carPosition -> System.out.println("|" + POSITION_BAR.repeat(Math.max(0, carPosition))));
    }
}
