package racingcar;

import java.util.List;

public class ResultView {

    public static void printCars(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getShowDistance());
        }
    }
}
