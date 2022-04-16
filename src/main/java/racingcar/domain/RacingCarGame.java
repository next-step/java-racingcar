package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;

public class RacingCarGame {

    private static final int MINIMUM_ROUND = 0;

    private final Cars cars;
    private int rounds;
    private final MoveStrategy moveStrategy;

    public RacingCarGame(Cars cars, int rounds, MoveStrategy moveStrategy) {
        this.cars = cars;
        this.rounds = validateRounds(rounds);
        this.moveStrategy = moveStrategy;
    }

    private int validateRounds(int rounds) {
        if (rounds <= MINIMUM_ROUND) {
            throw new IllegalArgumentException("rounds must be greater than 0");
        }
        return rounds;
    }

    public void moveCars() {
        if (isFinished()) {
            throw new IllegalStateException("game is already over");
        }
        rounds = rounds - 1;
        cars.move(moveStrategy);
    }

    public boolean isFinished() {
        return rounds <= MINIMUM_ROUND;
    }

}
