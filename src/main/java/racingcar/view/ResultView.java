package racingcar.view;

import racingcar.Car;
import racingcar.RacingGameResult;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ResultView {

    private static final String BANNER = "실행 결과";
    private static final String OUTPUT_CHARACTER = "-";
    private static final String COLON = " : ";
    private static final String NEW_LINE = "\n";

    private static final String SUFFIX_WINNER_PRINT = "가 최종 우승하였습니다.";

    private ResultView() {
        throw new AssertionError();
    }

    public static void printBanner() {
        System.out.println(BANNER);
    }

    public static void printResult(RacingGameResult racingGameResult){
        Car[] cars = racingGameResult.getCars();
        List<int[]> results = racingGameResult.getResults();

        results.stream()
                .forEach(positions -> printCarPositionPerRound(cars, positions));
    }

    public static void printWinner(String winner){
        System.out.println(winner + SUFFIX_WINNER_PRINT);
    }

    private static void printCarPositionPerRound(Car[] cars, int[] positions) {
        for (int i = 0; i < positions.length; i++) {
            System.out.println(cars[i].getName() + COLON + convertStringPosition(positions[i]) + NEW_LINE);
        }
    }

    private static String convertStringPosition(int position) {
        String result = OUTPUT_CHARACTER;
        for (int i = 0; i < position; i++) {
            result += result;
        }
        return result;
    }
}
