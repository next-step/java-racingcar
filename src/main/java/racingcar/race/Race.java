package racingcar.race;

import racingcar.rule.Rule;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final Rule rule;

    private final List<Car> cars;

    private final List<RaceRecord> raceRecords;

    public Race(List<Car> cars, Rule rule) {
        this.cars = cars;
        this.rule = rule;
        this.raceRecords = new ArrayList<>();
    }

    public void start() {
        for (Car car : cars) {
            moveCar(car);
            record(car);
        }
    }

    private void moveCar(Car car) {
        if(movable()) {
            car.move();
        }
    }

    private boolean movable() {
        return rule.verify();
    }

    private void record(Car car) {
        RaceRecord raceRecord = new RaceRecord(car);
        raceRecords.add(raceRecord);
    }

    public List<RaceRecord> raceRecords() {
        return raceRecords;
    }
}
