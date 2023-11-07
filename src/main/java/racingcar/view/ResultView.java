package racingcar.view;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

public class ResultView {

    private static final String DEFAULT_PRINT_PATTERN = "-";

    private ResultView() {
    }

    public static void printRacing(final Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getCarName() + " : " + DEFAULT_PRINT_PATTERN.repeat(car.getPosition()));
        }
        System.out.println("===========================================");
    }
}
