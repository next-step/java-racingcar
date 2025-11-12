package racingCar;

import java.util.List;

public class ResultView {
    public static void show(List<Car> cars) {
        for(Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
        }
        System.out.println();
    }
}
