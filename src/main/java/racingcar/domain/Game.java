package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final Cars cars;
    private TryCount tryCount;

    public Game(Cars cars, TryCount tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public List<List<CarStatus>> run() {
        List<List<CarStatus>> gameStatus = new ArrayList<>();
        gameStatus.add(getCarStatuses());
        while (tryCount.isNotZero()) {
            cars.moveAll();
            gameStatus.add(getCarStatuses());
            tryCount = tryCount.minus();
        }
        return gameStatus;
    }

    public List<CarName> findWinnerNames() {
        return cars.findWinnerNames();

    }

    public List<CarStatus> getCarStatuses() {
        return cars.mapToStatus();
    }
}
