package view;

import car.Car;
import car.Name;
import game.GameResult;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String RESULT_TITLE = "실행 결과";
    private static final String CAR_LOCATION_INDICATOR = "-";

    public static void printResultTitle() {
        System.out.println(RESULT_TITLE);
    }

    public static void printResult(List<GameResult> result) {
        result.stream()
                .map(ResultView::printCarsPosition)
                .forEach(s -> System.out.println(s + "\n"));
    }

    public static void printWinners(List<Car> winners) {
        List<String> winnerNames = getWinnerNames(winners);
        System.out.println(String.join(",", winnerNames) + "가 최종 우승했습니다.");
    }

    private static String printCarsPosition(GameResult carPositions) {
        return carPositions.getResult().stream()
            .map(ResultView::carPositionToIndicator)
            .collect(Collectors.joining("\n"));
    }

    private static List<String> getWinnerNames(List<Car> winners) {
        return winners.stream()
                .map(Car::getName)
                .map(Name::toString)
                .collect(Collectors.toList());
    }

    private static String carPositionToIndicator(int position) {
        return CAR_LOCATION_INDICATOR.repeat(position);
    }
}
