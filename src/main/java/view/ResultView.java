package view;

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

    public void printResultHeader() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printResult(List<Integer> carsPosition) {
        carsPosition.forEach(carPosition -> System.out.println(POSITION_BAR.repeat(Math.max(0, carPosition))));
        System.out.print(NEW_LINE);
    }
}
