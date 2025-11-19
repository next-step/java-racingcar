package racingCar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] names) {
        this(createCars(names));
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> value() {
        return cars;
    }

    private static List<Car> createCars(String[] names) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }

    public Winners getWinners() {
        return Winners.getWinners(cars);
    }
}
