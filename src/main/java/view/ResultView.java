package view;

import car.Car;
import car.Cars;
import game.GameResult;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String RESULT_TITLE = "실행 결과";
    private static final String CAR_LOCATION_INDICATOR = "-";

    public static void printResultTitle() {
        System.out.println(RESULT_TITLE);
    }

    public static void printResult(GameResult result) {
        result.getResults().stream()
                .map(ResultView::printCarsPosition)
                .forEach(s -> System.out.println(s + "\n"));
    }

    private static String printCarsPosition(List<Integer> carPositions) {
        return carPositions.stream()
            .map(ResultView::carPositionToIndicator)
            .collect(Collectors.joining("\n"));
    }

    private static String carPositionToIndicator(int position) {
        return CAR_LOCATION_INDICATOR.repeat(position);
    }
}
