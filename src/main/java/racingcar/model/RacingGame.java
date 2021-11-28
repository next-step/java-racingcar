package racingcar.model;

import java.util.List;

public class RacingGame {
    private final Cars cars;

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public void play() {
        cars.run();
    }

    public Cars getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        return cars.getWinners();
    }
}
