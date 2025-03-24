package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Integer> move() {
        return cars.stream()
                .map(Car::move)
                .collect(Collectors.toList());
    }
}
