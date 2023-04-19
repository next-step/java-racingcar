package racingcar;

import java.util.List;

public class ResultView {
    public static final String FOOTPRINT = "﹣";

    public static void printAllResult(List<Result> results) {
        System.out.println("[실행 결과]");
        for (Result result : results) {
            System.out.println("");
            printResult(result);
        }
    }

    private static void printResult(Result result) {
        List<CarScore> carScores = result.getCarScores();
        for (CarScore carScore: carScores) {
            String out = String.format("%s: %s", carScore.getCarName(), FOOTPRINT.repeat(carScore.getCarPosition()));
            System.out.println(out);
        }
    }

}
