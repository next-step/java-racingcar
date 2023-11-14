package racingcar.domain;

import racingcar.rule.Rule;

public class Race {

    private final Rule rule;
    private final Cars cars;
    private RaceRecords raceRecords;

    public Race(Cars cars, Rule rule) {
        this.cars = cars;
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
