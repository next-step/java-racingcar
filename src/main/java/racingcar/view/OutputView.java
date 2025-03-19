package racingcar.view;

import racingcar.Car;

import java.util.List;

public class OutputView {

    public static void showCarsLocation(List<Car> cars) {
        for (Car car : cars) {
            System.out.println("-".repeat(car.getCarLocation()));
        }
    }
}