package racingcar.domain;

import racingcar.rule.Rule;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars ofCars(List<Car> cars) {
        return new Cars(cars);
    }

    public static Cars ofString(List<String> carNames) {

        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            Car car = new Car(name);
            cars.add(car);
        }

        return new Cars(cars);
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

    public Races races(Rule rule, int count) {
        return Races.newInstance(this, rule, count);
    }
}
