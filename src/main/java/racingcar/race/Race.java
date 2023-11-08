package racingcar.race;

import racingcar.rule.Rule;

import java.util.List;

public class Race {

    private final Rule rule;

    private final Cars cars;

    private final RaceRecords raceRecords;

    public Race(List<Car> cars, Rule rule) {
        this.cars = new Cars(cars);
        this.rule = rule;
        this.raceRecords = new RaceRecords();
    }

    public void start() {
        cars.move(rule);
        raceRecords.record(cars.list());
    }

    public RaceRecords raceRecords() {
        return raceRecords;
    }
}
