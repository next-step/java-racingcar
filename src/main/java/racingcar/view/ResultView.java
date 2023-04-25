package racingcar.view;

import racingcar.domain.Score;
import racingcar.domain.Scores;

import java.util.List;

public class ResultView {
    public static final String RUN_RESULT_MESSAGE = "실행결과";
    public static final String MOVE_RESULT_EXPRESSION = "-";
    public static final String WINNER_RESULT_EXPRESSION = "가 최종 우승했습니다";
    public static final String DELIMITER = ",";

    public static void printResult(List<Scores> scores){
        System.out.println(RUN_RESULT_MESSAGE);
        scores.forEach(score -> {
            printScore(score);
            System.out.println();
        });
        printWinner(scores);
    }

    private static void printWinner(List<Scores> scores) {
        Scores lastScores = scores.get(scores.size() -1);
        List<String> winnerNames = lastScores.findWinnerNames();
        final String winnersWithDelimiter = String.join(DELIMITER, winnerNames);
        System.out.println(winnersWithDelimiter + WINNER_RESULT_EXPRESSION);
    }

    private static void printScore(Scores scores) {
        for (Score score : scores.findAllScores()) {
            printDistance(score);
            System.out.println();
        }
    }

    private static void printDistance(Score score) {
        System.out.printf("%s : ", score.findCarName());
        int bound = score.findPoint();
        for (int i = 0; i < bound; i++) {
            System.out.print(MOVE_RESULT_EXPRESSION);
        }
    }
}
