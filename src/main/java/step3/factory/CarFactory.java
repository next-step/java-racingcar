package step3.factory;

import step3.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public static List<Car> create(int numberOfCars) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
        return cars;
    }
    private CarFactory() {
        throw new AssertionError();
    }
}
