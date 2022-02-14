package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.strategy.MoveStrategy;

public class RacingGame {

    private final Cars cars;
    private final MoveStrategy moveStrategy;
    private final TryRaceCount tryRaceCount;

    public RacingGame(Cars cars, TryRaceCount tryRaceCount, MoveStrategy moveStrategy) {
        this.cars = cars;
        this.tryRaceCount = tryRaceCount;
        this.moveStrategy = moveStrategy;
    }

    public List<Cars> race() {
        List<Cars> racingLog = new ArrayList<>();
        while (tryRaceCount.isOngoing()) {
            racingLog.add(cars);
            cars.moveAll(moveStrategy);
            tryRaceCount.runOneStep();
        }
        return racingLog;
    }

    public boolean isOngoing() {
        return tryRaceCount.isOngoing();
    }

    public Cars getCars() {
        return cars;
    }
}

