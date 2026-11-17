package racingcar.view;

import java.util.List;

public class ResultView {
    private ResultView() {
    }

    public static void showResult(List<List<Integer>> roundResults) {
        System.out.println();
        System.out.println("실행 결과");

        showRoundResults(roundResults);
    }

    private static void showRoundResults(List<List<Integer>> roundResults) {
        for (List<Integer> roundResult : roundResults) {
            showCarPositions(roundResult);
            System.out.println();
        }
    }

    private static void showCarPositions(List<Integer> roundResult) {
        for (int position : roundResult) {
            System.out.println(PositionFormatter.format(position));
        }
    }
}
