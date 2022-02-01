package racinggame.controller;

import racinggame.domain.car.Cars;
import racinggame.domain.history.RoundHistories;
import racinggame.domain.random.RandomGoRule;

public class RacingGameController {

    private final Cars cars;
    private final int tryNumber;

    public RacingGameController(String[] carNames, int tryNumber) {
        this.cars = new Cars(carNames);
        this.tryNumber = tryNumber;
    }

    public RoundHistories race() {
        final RandomGoRule randomGenerator = new RandomGoRule();
        final RoundHistories roundHistories = new RoundHistories();
        for (int i = 0; i < tryNumber; i++) {
            cars.move(randomGenerator);
            roundHistories.captureRoundHistory(cars);
        }
        return roundHistories;
    }

}
