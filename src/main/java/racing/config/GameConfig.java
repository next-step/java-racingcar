package racing.config;

import racing.domain.model.Cars;
import racing.domain.strategy.MoveStrategy;
import racing.domain.strategy.ThresholdMoveStrategy;

public class GameConfig {
    private final Cars cars;
    private final int attemptCount;
    private final MoveStrategy moveStrategy = new ThresholdMoveStrategy();

    public GameConfig(final Cars cars, final int attemptCount) {
        this.cars = cars;
        this.attemptCount = attemptCount;
    }

    public Cars getCars() {
        return cars;
    }

    public int getAttemptCount() {
        return attemptCount;
    }

    public MoveStrategy getMoveStrategy() {
        return moveStrategy;
    }
}
