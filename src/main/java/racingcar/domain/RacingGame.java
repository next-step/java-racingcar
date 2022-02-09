package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
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

    public List<Cars> race() {
        List<Cars> racinglog = new ArrayList<>();
        while (isOngoing()) {
            racinglog.add(cars);
            cars.moveAll(moveStrategy);
            tryRaceCount--;
        }
        return racinglog;
    }

    public boolean isOngoing() {
        return tryRaceCount > 0;
    }

    public Cars getCars() {
        return cars;
    }
}

