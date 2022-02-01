package racingcar.domain;

import java.util.List;
import racingcar.domain.strategy.MoveStrategy;

public class RacingGame {

    private final Cars cars;
    private final MoveStrategy moveStrategy;
    private int raceCount;

    public RacingGame(List<String> nameList, int raceCount, MoveStrategy moveStrategy) {
        this.cars = Cars.of(nameList);
        this.raceCount = raceCount;
        this.moveStrategy = moveStrategy;
    }

    public void race() {
        cars.moveAll(moveStrategy);
        raceCount--;
    }

    public boolean isOngoing() {
        return raceCount > 0;
    }

    public Cars getCars() {
        return cars;
    }
}

