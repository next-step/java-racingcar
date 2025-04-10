package domain;

import java.util.List;

public class RacingGame {
    private final Cars cars;

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public int size() {
        return cars.size();
    }

    public List<Car> findWinners() {
        return cars.getCarsWithSamePosition(cars.getMaxPosition());
    }

}
