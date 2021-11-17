package study.racing.domain.car;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import study.racing.domain.Distance;
import study.racing.domain.Name;
import study.racing.domain.rule.Rule;
import study.racing.exception.InvalidMostMovedException;

public class RacingCars {

    public static final String NEED_TO_EXIST_MOST_MOVED_CAR_AT_LEAST_ONE = "need to exist most moved car at least one";
    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public static RacingCars from(List<Name> carNames) {
        return carNames.stream()
                       .map(Car::new)
                       .collect(Collectors.collectingAndThen(Collectors.toList(), RacingCars::new));
    }

    public RacingCars raceAll(Rule rule) {
        cars.forEach(car -> car.moveOrStop(rule));
        return new RacingCars(cars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public RacingCars mostMovedCars() {
        Distance max = getGreatestDistance();
        return findMostMovedCars(max);
    }

    private Distance getGreatestDistance() {
        return cars.stream()
                   .map(Car::getDistance)
                   .max(Comparator.comparing(Distance::getDistance))
                   .orElseThrow(() -> new InvalidMostMovedException(NEED_TO_EXIST_MOST_MOVED_CAR_AT_LEAST_ONE));
    }

    private RacingCars findMostMovedCars(Distance max) {
        return cars.stream()
                   .filter(car -> car.isEqualDistance(max))
                   .collect(Collectors.collectingAndThen(Collectors.toList(), RacingCars::new));
    }

    public List<String> carNames() {
        return cars.stream()
                   .map(this::convertToName)
                   .collect(Collectors.toList());
    }

    private String convertToName(Car car) {
        return car.getName().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RacingCars that = (RacingCars) o;
        return Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
