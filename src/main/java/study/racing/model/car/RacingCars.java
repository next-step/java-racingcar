package study.racing.model.car;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import study.racing.model.rule.Rule;

public class RacingCars {

    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public void raceAll(Rule rule) {
        cars.forEach(car -> car.moveOrStop(rule));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> mostMovedCars() {
        int max = cars.stream()
                      .mapToInt(Car::getDistance)
                      .max()
                      .getAsInt();

        return cars.stream()
                   .filter(car -> car.getDistance() == max)
                   .collect(Collectors.toList());
    }
}
