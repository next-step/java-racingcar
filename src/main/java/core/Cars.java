package core;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars fromCarNames(List<String> carNames) {
        List<Car> receivedCars = new ArrayList<>();
        for (String carName : carNames) {
            receivedCars.add(Car.create(carName));
        }

        return new Cars(receivedCars);
    }

    public static Cars fromCars(List<Car> cars) {
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return cars;
    }
}
