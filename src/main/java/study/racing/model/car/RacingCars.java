package study.racing.model.car;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import study.racing.model.rule.Rule;

public class RacingCars {

    private final List<Car> cars;

    public RacingCars(List<String> carNames) {
        cars = carNames.stream().map(Car::new).collect(Collectors.toList());
    }

    public void raceAll(Rule rule) {
        cars.forEach(car -> car.moveOrStop(rule));
    }

    public List<Car> result() {
        return Collections.unmodifiableList(cars);
    }
}
