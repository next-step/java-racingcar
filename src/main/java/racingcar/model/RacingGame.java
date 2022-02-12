package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final TryCount tryCount;
    private MoveStrategy moveStrategy;

    public RacingGame(Cars cars, int tryCount) {
        this.cars = cars;
        this.tryCount = new TryCount(tryCount);
    }

    public RacingGame(Cars cars, int tryCount, MoveStrategy moveStrategy) {
        this(cars, tryCount);
        this.moveStrategy = moveStrategy;
    }

    public RaceResults startRace() {
        List<List<Car>> totalResult = new ArrayList<>();
        while (tryCount.isPlaying()) {
            totalResult.add(cars.moveCars(moveStrategy));
            tryCount.decreaseTryCount();
        }
        return new RaceResults(totalResult);
    }
}
