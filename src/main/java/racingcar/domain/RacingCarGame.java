package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;

public class RacingCarGame {

    private final Cars cars;
    private int rounds;
    private final MoveStrategy moveStrategy;

    public RacingCarGame(Cars cars, int rounds, MoveStrategy moveStrategy) {
        this.cars = cars;
        this.rounds = rounds;
        this.moveStrategy = moveStrategy;
    }

    public void proceedRound() {
        decreaseGameRound();
        cars.move(moveStrategy);
    }

    private void decreaseGameRound() {
        if (rounds <= 0) {
            throw new IllegalStateException("game is already over");
        }
        rounds = rounds - 1;
    }
}
