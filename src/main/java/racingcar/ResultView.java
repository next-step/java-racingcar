package racingcar;

import java.util.List;

public class ResultView {

    public static void printCars(RacingCar racingCar) {
        List<String> cars = racingCar.getCars();
        for (String car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }
}
