package step3;

import java.util.List;

public class ResultView {
    private final String carScore = "-";

    public void printScore(List<List<Integer>> scoreBoard) {
        System.out.println(scoreBoard);
        System.out.println("실행 결과");

        for (List<Integer> scoreAtOneTime : scoreBoard) {
            this.printScoreAtOneTime(scoreAtOneTime);
        }
    }

    private void printScoreAtOneTime(List<Integer> scoreAtOneTime) {
        for (int score : scoreAtOneTime) {
            System.out.println(carScore.repeat(score));
        }
        System.out.println();
    }
}
