package racing.domain;

import java.util.List;

public class RacingGameInfo {

    private int tryCount;
    private final Cars cars;

    public RacingGameInfo(Cars cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public List<Car> getWinners() {
        return cars.getWinners();
    }
}