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

    public List<Integer> getAllPositions() {
        return this.cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
    }
}
