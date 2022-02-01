package racingcar.service;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.strategy.MoveStrategy;

public class GameLauncher {

    private final Cars cars;
    private final int endRaceCount;
    private int currentCount;
    private final MoveStrategy moveStrategy;

    public GameLauncher(List<String> nameList, int endRaceCount, MoveStrategy moveStrategy) {
        this.cars = Cars.of(nameList);
        this.currentCount = 0;
        this.endRaceCount = endRaceCount;
        this.moveStrategy = moveStrategy;
    }

    public void race() {
        cars.moveAll(moveStrategy);
        currentCount++;
    }

    public boolean isOngoing() {
        return endRaceCount >= currentCount;
    }

    public Cars getCars() {
        return cars;
    }
}

