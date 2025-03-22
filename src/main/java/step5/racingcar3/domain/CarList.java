package step5.racingcar3.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarList {

    private final List<Car> cars;

    public CarList(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> value() {
        return cars;
    }

    public void run() {
        for (Car car : cars) {
            car.run();
        }
    }


    public CarList winners() {
        Position maxPosition = maxPosition();
        return new CarList(
            cars.stream().filter(car -> car.position().equals(maxPosition)).collect(Collectors.toList()));
    }

    private Position maxPosition() {
        return Collections.max(cars.stream().map(Car::position).collect(Collectors.toList()));
    }


}
