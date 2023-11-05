package racinggame.domain;

import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> racing() {
        racingCar();
        return cars;
    }

    private void racingCar() {
        cars.forEach(Car::moving);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

}
