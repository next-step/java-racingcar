package study.racing.domain.car;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import study.racing.domain.Distance;
import study.racing.domain.Name;
import study.racing.domain.rule.Rule;

public class RacingCars {

    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public static RacingCars from(List<Name> carNames) {
        List<Car> cars = carNames.stream()
                                 .map(Car::new)
                                 .collect(Collectors.toList());
        return new RacingCars(cars);
    }

    public void raceAll(Rule rule) {
        cars.forEach(car -> car.moveOrStop(rule));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> mostMovedCars() {
        Distance max = getGreatestDistance();
        return findMostMovedCars(max);
    }

    private Distance getGreatestDistance() {
        return cars.stream()
                   .map(Car::getDistance)
                   .max(Comparator.comparing(Distance::getDistance))
                   .get();
    }

    private List<Car> findMostMovedCars(Distance max) {
        return cars.stream()
                   .filter(car -> car.isEqualDistance(max))
                   .collect(Collectors.toList());
    }
}
