package racinggame.domain;

import racinggame.domain.car.Cars;
import racinggame.domain.history.RoundHistories;
import racinggame.domain.random.GoRule;
import racinggame.domain.random.RandomGoRule;

public class RacingGame {

    private static final GoRule GO_RULE = new RandomGoRule();

    private final Cars cars;
    private final int tryNumber;
    private final RoundHistories roundHistories;

    public RacingGame(String[] inputPlayerName, int inputTryNumber) {
        this.cars = new Cars(inputPlayerName);
        this.tryNumber = inputTryNumber;
        this.roundHistories = new RoundHistories();
    }

    public void race() {
        for (int i = 0; i < tryNumber; i++) {
            roundHistories.captureRoundHistory(cars.move(GO_RULE));
        }
    }

    public RoundHistories getRoundHistories() {
        return this.roundHistories;
    }
}
