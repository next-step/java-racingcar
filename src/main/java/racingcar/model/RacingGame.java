package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final TryCount tryCount;

    public RacingGame(Cars cars, int tryCount) {
        this.cars = cars;
        this.tryCount = new TryCount(tryCount);
    }

    public List<RaceResult> startRace() {
        List<RaceResult> totalResult = new ArrayList<>();
        while (tryCount.isPlaying()) {
            RaceResult raceResult = new RaceResult(cars.moveCars());
            totalResult.add(raceResult);
            tryCount.decreaseTryCount();
        }
        return totalResult;
    }

}
