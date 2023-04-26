package racingcar;

import java.util.List;

public class ResultView {
    public static final String FOOTPRINT = "﹣";

    public static void printAllResult(ScoreBoard scoreBoard) {
        System.out.println("[실행 결과]");
        for (Result result : scoreBoard.getResults()) {
            printResult(result);
            System.out.println("");
        }
        printWinners(scoreBoard.getWinners());
    }

    private static void printResult(Result result) {
        List<CarScore> carScores = result.getCarScores();
        for (CarScore carScore: carScores) {
            String out = String.format("%s: %s", carScore.getCarName(), FOOTPRINT.repeat(carScore.getCarPosition()));
            System.out.println(out);
        }
    }

    private static void printWinners(List<String> winners) {
        String out = String.format("%s가 최종 우승했습니다.", String.join(", ", winners));
        System.out.println(out);
    }
}
