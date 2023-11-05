package racingcar.view;

import racingcar.domain.car.Cars;

public class ResultView {

    private static final String DEFAULT_PRINT_PATTERN = "-";

    private ResultView() {
    }

    public static void printResult(final Cars cars) {
        cars.getCars().forEach(car -> System.out.println(DEFAULT_PRINT_PATTERN.repeat(car.getPosition())));
        System.out.println("===========================================");
    }
}
