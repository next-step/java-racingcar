package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;

import java.util.List;

public class RacingCarGame {

    private final List<Car> cars;
    private int rounds;
    private final MoveStrategy moveStrategy;

    public RacingCarGame(List<Car> cars, int rounds, MoveStrategy moveStrategy) {
        this.cars = cars;
        this.rounds = rounds;
        this.moveStrategy = moveStrategy;
    }

    public void proceedRound() {
        decreaseGameRound();
        cars.forEach(moveStrategy::moveOrStop);
    }

    private void decreaseGameRound() {
        if (rounds <= 0) {
            throw new IllegalStateException("game is already over");
        }

        rounds = rounds - 1;
    }
}
