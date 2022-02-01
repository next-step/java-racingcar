package racingcar.service;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.strategy.MoveStrategy;

public class GameLauncher {

    private final Cars cars;
    private final int endRaceCount;
    private int currentCount;

    public GameLauncher(List<String> nameList, int endRaceCount) {
        this.cars = Cars.of(nameList);
        this.currentCount = 0;
        this.endRaceCount = endRaceCount;
    }

    public void race(MoveStrategy moveStrategy) {
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

