package racingcar.model;

import racingcar.util.NumberGenerator;
import racingcar.util.RandomGenerator;

public class RacingGame {

    private NumberGenerator numberGenerator;
    private Cars cars;

    private RacingGame(Cars cars) {
        this.cars = cars;
        this.numberGenerator = new RandomGenerator();
    }

    RacingGame(Cars cars, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    public static RacingGame generate(String names) {
        Cars cars = Cars.from(names);
        return new RacingGame(cars);
    }

    public Cars start() {
        return cars;
    }

    public Cars playOfOneRound() {
        return cars.move(numberGenerator);
    }

    public WinningResult winningResult() {
        return WinningResult.of(cars);
    }
}
