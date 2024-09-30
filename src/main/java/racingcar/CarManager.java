package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarManager {
    public static List<Car> createCarsByCnt(int cntOfCar) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < cntOfCar; i++) {
            cars.add(new Car());
        }
        return cars;
    }
}
