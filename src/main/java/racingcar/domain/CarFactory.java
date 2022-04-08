package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    private CarFactory() {
        throw new AssertionError();
    }

    public static List<Car> createCars(int size) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            cars.add(new Car());
        }
        return cars;
    }
}
