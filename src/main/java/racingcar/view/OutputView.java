package racingcar.view;

import racingcar.Car;

public class OutputView {

    public static void showCarsLocation(Car[] cars) {
        for (Car car : cars) {
            System.out.println("-".repeat(car.getCarLocation()));
        }
    }
}