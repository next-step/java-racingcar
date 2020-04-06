package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }

    public void moveAll() {
        cars.forEach(Car::moveIfPossible);
    }

    public List<Car> getCars() {
        return cars;
    }
}