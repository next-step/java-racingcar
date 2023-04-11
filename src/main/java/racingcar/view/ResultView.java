package racingcar.view;

import racingcar.domain.Score;

import java.util.List;

public class ResultView {
    public static final String RUN_RESULT_MESSAGE = "실행결과";
    public static final String MOVE_RESULT = "-";

    public void printResult(List<Score> scores){
        System.out.println(RUN_RESULT_MESSAGE);
        for (Score score : scores) {
            printScore(score);
            System.out.println();
        }
    }

    private void printScore(Score score) {
        for (int i = 0; i < score.getPoint(); i++) {
            System.out.print(MOVE_RESULT);
        }
    }
}
