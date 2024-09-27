package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarManager {
    public List<Car> createCarByCnt(int cntOfCar) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < cntOfCar; i++) {
            cars.add(new Car("car"+i));
        }
        return cars;
    }
}
