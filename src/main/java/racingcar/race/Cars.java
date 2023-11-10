package racingcar.race;

import racingcar.domain.Car;
import racingcar.domain.RaceRecord;
import racingcar.rule.Rule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars() {
        this(new ArrayList<>());
    }

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void add(Car car) {
        cars.add(car);
    }

    public RaceRecords move(Rule rule) {
        for (Car car : cars) {
            moveCar(rule, car);
        }

        return raceRecords();
    }

    private void moveCar(Rule rule, Car car) {
        if (movable(rule)) car.move();
    }

    private boolean movable(Rule rule) {
        return rule.verify();
    }

    private RaceRecords raceRecords() {
        return new RaceRecords(cars.stream()
                .map(Car::record)
                .collect(Collectors.toList()));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
