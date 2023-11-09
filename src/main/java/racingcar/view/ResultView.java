package racingcar.view;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import java.util.List;

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

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}
