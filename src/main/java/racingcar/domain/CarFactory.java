package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    private CarFactory() {
        throw new AssertionError();
    }

    public static List<Car> generateCarsOfSize(int carSize) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carSize; i++) {
            cars.add(new Car());
        }
        return cars;
    }
}
