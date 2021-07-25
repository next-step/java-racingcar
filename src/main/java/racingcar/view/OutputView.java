package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String MSG_RESULT = "실행 결과";

    public void printResultMessage() {
        System.out.println(MSG_RESULT);
    }

    public void printStatusFromScores(List<Integer> scores) {
        scores.forEach(score -> {
            for (int i = 0; i < score; i++) {
                System.out.print("-");
            }
            System.out.println();
        });
        System.out.println();
    }
}
