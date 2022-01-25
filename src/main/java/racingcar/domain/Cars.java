package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> filterWinners() {
        int max = calculateMax();
        return cars.stream()
            .filter(car -> car.distance() == max)
            .collect(Collectors.toList());
    }

    public List<Car> get() {
        return cars;
    }

    private int calculateMax() {
        return cars.stream()
            .map(Car::distance)
            .max(Integer::compare)
            .orElseThrow(IllegalArgumentException::new);
    }
}
