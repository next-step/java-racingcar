package racinggame.service;

import racinggame.domain.car.Cars;
import racinggame.domain.history.RoundHistories;
import racinggame.domain.random.RandomGoRule;

public class RacingGameService {

    private final RandomGoRule randomGenerator = new RandomGoRule();
    private final RoundHistories roundHistories = new RoundHistories();

    public RoundHistories race(final Cars cars, final int tryNumber) {
        for (int i = 0; i < tryNumber; i++) {
            roundHistories.captureRoundHistory(cars.move(randomGenerator));
        }
        return roundHistories;
    }

}
