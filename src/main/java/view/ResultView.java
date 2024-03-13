package view;

import racingCar.RacingCar;
import racingCar.RacingCars;

public class ResultView {

    public static void printResult(RacingCars cars) {
        for (RacingCar car : cars.findCars()) {
            System.out.println(car.toString());
        }
        System.out.println();
    }
}
