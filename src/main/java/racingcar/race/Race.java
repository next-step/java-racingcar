package racingcar.race;

import racingcar.domain.Car;
import racingcar.rule.Rule;

import java.util.List;

public class Race {

    private final Rule rule;
    private final Cars cars;
    private RaceRecords raceRecords;

    public Race(List<Car> cars, Rule rule) {
        this.cars = new Cars(cars);
        this.rule = rule;
    }

    public RaceRecords start() {
        raceRecords = cars.move(rule);
        return raceRecords();
    }

    public RaceRecords raceRecords() {
        return raceRecords;
    }
}
