package racingcar;

import java.util.List;

public class ResultView {

    public static void printCars() {
        List<String> cars = RacingCar.getInstance().getCars();
        for (String car : cars) {
            System.out.println(car);
        }
    }
}
