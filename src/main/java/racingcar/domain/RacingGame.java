package racingcar.domain;

import racingcar.strategy.MoveStrategy;

public class RacingGame {

    private int tryCount;

    private Cars cars;

    public RacingGame(Cars cars, int tryCount) {
        this.tryCount = tryCount;
        this.cars = cars;
    }

    public boolean isEndGame() {
        return tryCount > 0 ? false : true;
    }

    public Cars start(MoveStrategy moveStrategy) {
        tryCount--;
        cars.moveCars(moveStrategy);
        return cars;
    }

    public Cars cars() {
        return cars;
    }
}
