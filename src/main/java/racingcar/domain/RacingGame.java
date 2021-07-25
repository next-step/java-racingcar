package racingcar.domain;

import racingcar.rules.Rule;

import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final Rule rule;

    public RacingGame(List<String> names, Rule rule) {
        this.cars = new Cars(names);
        this.rule = rule;
    }

    public Cars next() {
        return cars.move(rule);
    }
}
