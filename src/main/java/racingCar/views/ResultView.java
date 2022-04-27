package racingCar.views;

import racingCar.domains.Car;

import java.util.List;

public class ResultView {
    public static void showRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println("-".repeat(car.getPosition()));
        }
        System.out.println();
    }
}
