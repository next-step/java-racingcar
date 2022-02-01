package racingcar.domain;

import java.util.List;
import racingcar.domain.strategy.MoveStrategy;

public class RacingGame {

    private final Cars cars;
    private final MoveStrategy moveStrategy;
    private int tryRaceCount;

    public RacingGame(List<String> nameList, int tryRaceCount, MoveStrategy moveStrategy) {
        this.cars = Cars.of(nameList);
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

