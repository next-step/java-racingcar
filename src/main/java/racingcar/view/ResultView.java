package racingcar.view;

import racingcar.domain.Score;
import racingcar.domain.Scores;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {
    public static final String RUN_RESULT_MESSAGE = "실행결과";
    public static final String MOVE_RESULT_EXPRESSION = "-";

    public static void printResult(List<Scores> scores){
        System.out.println(RUN_RESULT_MESSAGE);
        scores.forEach(score -> {
            printScore(score);
            System.out.println();
        });
    }

    private static void printScore(Scores scores) {
        for (Score score : scores.findAllScores()) {
            printDistance(score);
            System.out.println();
        }
    }

    private static void printDistance(Score score) {
        IntStream.range(0, score.getPoint())
                .mapToObj(i -> MOVE_RESULT_EXPRESSION)
                .forEach(System.out::print);
    }
}
