package domain;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final int round;

    public RacingGame(Cars cars) {
        this(cars, 0);
    }

    public RacingGame(Cars cars, int round) {
        this.cars = cars;
        this.round = round;
    }

    public void moveByRound() {
        for (int i = 0; i < round; i++) {
            cars.moveAll();
        }
    }

    public int size() {
        return cars.size();
    }

    public List<Car> findWinners() {
        return cars.getCarsWithSamePosition(cars.getMaxPosition());
    }

}
