package racingCar;

import java.util.List;

public class ResultView {
    public void show(List<Car> cars) {
        for(Car car : cars) {
            System.out.println("-".repeat(car.getDistance()));
        }
        System.out.println();
    }
}
