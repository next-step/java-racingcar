package racinggame.service;

import racinggame.domain.car.Cars;
import racinggame.domain.history.RoundHistories;
import racinggame.domain.random.RandomGoRule;

public class RacingGameService {

    private final RandomGoRule randomGenerator = new RandomGoRule();
    private final RoundHistories roundHistories = new RoundHistories();

    public RoundHistories race(Cars cars, int tryNumber) {
        for (int i = 0; i < tryNumber; i++) {
            cars.move(randomGenerator);
            roundHistories.captureRoundHistory(cars);
        }
        return roundHistories;
    }

}
