package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    private final List<Car> cars;

    public CarFactory(int userInput) {
        cars = new ArrayList<>();
        createCars(userInput);
    }

    public List<Car> createCars(int carCount) {
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}
