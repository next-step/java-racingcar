package racinggame.domain;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class RacingCars {

    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public List<Car> winners() {
        return cars.stream()
                .collect(groupingBy(Car::getCarDistance))
                .entrySet()
                .stream()
                .max(Comparator.comparing(entry -> entry.getKey().getDistance()))
                .get()
                .getValue()
                .stream()
                .collect(toList());
    }
}
