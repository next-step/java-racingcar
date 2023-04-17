package racing;

import java.util.List;

public class ResultView {
    private static final String CAR_SCORE = "-";

    private ResultView() {
    }

    public static void printScore(List<List<Integer>> scoreBoard) {
        System.out.println("실행 결과");

        for (List<Integer> scoreAtOneTime : scoreBoard) {
            printScoreAtOneTime(scoreAtOneTime);
        }
    }

    private static void printScoreAtOneTime(List<Integer> scoreAtOneTime) {
        for (int score : scoreAtOneTime) {
            System.out.println(CAR_SCORE.repeat(score));
        }
        System.out.println();
    }
}
