package racingcar.domain;

import racingcar.rules.Rule;

public class RacingGame {

    private Cars cars;
    private Rule rule;

    public RacingGame(Cars cars, Rule rule) {
        this.cars = cars;
        this.rule = rule;
    }

    public Cars next() {
        return new Cars(cars.move(rule).getElements());
    }
}
