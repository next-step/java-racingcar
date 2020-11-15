package racing.view;

import racing.domain.Car;
import racing.domain.Cars;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResultView {
    private static final String DELIMITER = ",";
    private static final String VICTORY_MSG = "가 최종우승 했습니다.";

    private ResultView() {
    }

    public static void printVictoryCarNames(Cars cars) {
        System.out.println(getVictoryCarNames(cars) + VICTORY_MSG);
    }

    private static String getVictoryCarNames(Cars cars) {
        return cars.getCarList().stream()
                .filter(car -> car.isGreaterOrEqualsPosition(cars.getVictoryPosition()))
                .map(Car::getName)
                .collect(Collectors.joining(DELIMITER));
    }
}
