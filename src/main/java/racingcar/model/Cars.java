package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        this.cars.forEach(Car::move);
    }

    public List<String> getStatus() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.toList());
    }
}
