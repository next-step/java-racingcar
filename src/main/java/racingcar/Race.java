package racingcar;

import racingcar.rule.Rule;
import racingcar.util.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private Rule rule;

    private NumberGenerator numberGenerator;

    private List<Car> cars;

    private List<RaceRecord> raceRecords;

    public Race(List<Car> cars, Rule rule, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.rule = rule;
        this.numberGenerator = numberGenerator;
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
        return rule.verify(numberGenerator.get());
    }

    private void record(Car car) {
        RaceRecord raceRecord = new RaceRecord(car);
        raceRecords.add(raceRecord);
    }

    public List<RaceRecord> raceRecords() {
        return raceRecords;
    }
}
