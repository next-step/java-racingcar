package racingcar.view;

import racingcar.domain.RoundResult;

import java.util.List;

public class ResultView {
    private ResultView() {
    }

    public static void showResult(List<RoundResult> roundResults) {
        System.out.println();
        System.out.println("실행 결과");

        showRoundResults(roundResults);
    }

    private static void showRoundResults(List<RoundResult> roundResults) {
        for (RoundResult roundResult : roundResults) {
            showCarPositions(roundResult.positions());
            System.out.println();
        }
    }

    private static void showCarPositions(List<Integer> roundResult) {
        for (int position : roundResult) {
            System.out.println(PositionFormatter.format(position));
        }
    }
}
