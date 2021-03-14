package step3.service;

import step3.model.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingService {

    public List<Car> makeCars(int numberOfCars) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
        return cars;
    }
}
