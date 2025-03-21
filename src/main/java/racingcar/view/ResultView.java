package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class ResultView {
    public static void printRaceStatus(List<Car> cars) {
        cars.forEach(car -> System.out.println("-".repeat(car.getPosition())));
        System.out.println();
    }
}


