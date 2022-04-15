package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;

public class RacingCarGame {

    private final Cars cars;
    private int rounds;
    private final MoveStrategy moveStrategy;

    public RacingCarGame(Cars cars, int rounds, MoveStrategy moveStrategy) {
        this.cars = cars;
        this.rounds = validateRounds(rounds);
        this.moveStrategy = moveStrategy;
    }

    private int validateRounds(int rounds) {
        if (rounds <= 0) {
            throw new IllegalArgumentException("rounds must be greater than 0");
        }
        return rounds;
    }

    public boolean isFinished() {
        return rounds == 0;
    }

    public void moveCars() {
        if (rounds <= 0) {
            throw new IllegalStateException("game is already over");
        }
        rounds = rounds - 1;
        cars.move(moveStrategy);
    }
}
