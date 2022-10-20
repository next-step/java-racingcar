package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(int carCount) {
        this(createCars(carCount));
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    private static List<Car> createCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    public Iterable<Car> cars() {
        return Collections.unmodifiableList(cars);
    }
}
