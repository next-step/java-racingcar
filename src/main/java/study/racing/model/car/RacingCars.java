package study.racing.model.car;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import study.racing.model.Name;
import study.racing.model.rule.Rule;

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
        int max = getGreatestDistance();
        return findMostMovedCars(max);
    }

    private int getGreatestDistance() {
        return cars.stream()
                   .mapToInt(Car::getDistance)
                   .max()
                   .getAsInt();
    }

    private List<Car> findMostMovedCars(int max) {
        return cars.stream()
                   .filter(car -> car.isEqualDistance(max))
                   .collect(Collectors.toList());
    }
}
