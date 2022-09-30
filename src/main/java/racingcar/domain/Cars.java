package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars create(int carCount) {
        return new Cars(createCars(carCount));
    }

    public List<Distance> move() {
        List<Distance> results = new ArrayList<>();
        for (Car car : cars) {
            results.add(car.move(Moving.create()));
        }
        return results;
    }

    private static List<Car> createCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int count = 0; count < carCount; count++) {
            cars.add(new Car());
        }
        return cars;
    }
}
