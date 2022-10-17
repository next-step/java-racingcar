package step4;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String TRY_RESULT_MESSAGE = "실행 결과";
    private static final String RESULT_SEPARATOR = " : ";
    private static final String DISTANCE_INDICATOR = "-";

    private ResultView() {}

    public static void printTryResultMessage() {
        System.out.println(TRY_RESULT_MESSAGE);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printResult(List<RacingResult> racingResults) {
        printTryResultMessage();
        for (RacingResult racingResult : racingResults) {
            printRacingResult(racingResult);
            printNewLine();
        }
    }

    public static void printRacingResult(RacingResult racingResult) {
        for (Car result : racingResult.getResults()) {
            System.out.println(getResultMessage(result));
        }
    }

    public static void printWinner(List<Car> cars) {
        String winners = cars.stream()
            .map(car -> car.getName())
            .collect(Collectors.joining(", "));
        System.out.println(String.format("%s가 최종 우승했습니다.", winners));
    }

    public static String getResultMessage(Car result) {
        StringBuilder resultSb = new StringBuilder();
        resultSb.append(result.getName())
            .append(RESULT_SEPARATOR)
            .append(DISTANCE_INDICATOR.repeat(result.getDistance()));
        return resultSb.toString();
    }
}
