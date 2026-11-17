package racingcar.view;

import java.util.List;

public class ResultView {
    private static final PositionFormatter POSITION_FORMATTER = new PositionFormatter();

    public void showResult(List<List<Integer>> roundResults) {
        System.out.println();
        System.out.println("실행 결과");

        showRoundResults(roundResults);
    }

    private void showRoundResults(List<List<Integer>> roundResults) {
        for (List<Integer> roundResult : roundResults) {
            showCarPositions(roundResult);
            System.out.println();
        }
    }

    private void showCarPositions(List<Integer> roundResult) {
        for (int position : roundResult) {
            System.out.println(POSITION_FORMATTER.format(position));
        }
    }
}
