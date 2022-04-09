package racingcar.factory;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarsFactory {
    public static List<Car> create(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }

        return cars;
    }
}
