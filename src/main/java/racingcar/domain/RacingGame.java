package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;

public class RacingGame {

    private final Cars cars;
    private final MoveStrategy moveStrategy;
    private int tryRaceCount;

    public RacingGame(Cars cars, int tryRaceCount, MoveStrategy moveStrategy) {
        this.cars = cars;
        this.tryRaceCount = tryRaceCount;
        this.moveStrategy = moveStrategy;
    }

    public void race() {
        cars.moveAll(moveStrategy);
        tryRaceCount--;
    }

    public boolean isOngoing() {
        return tryRaceCount > 0;
    }

    public Cars getCars() {
        return cars;
    }
}

