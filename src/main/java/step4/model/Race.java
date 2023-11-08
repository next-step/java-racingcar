package step4.model;

import java.util.List;

public class Race {

    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void start() {
        this.cars.forEach(Car::go);
    }
}
