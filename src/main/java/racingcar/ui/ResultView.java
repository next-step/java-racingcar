package racingcar.ui;

import racingcar.domain.Car;

import java.util.List;

public class ResultView {

    private static final String POSITION_DISPLAY = "-";

    public static void printResult(List<Car> cars) {
        cars.stream()
                .map(Car::getPosition)
                .forEach(System.out::println);
    }

}
