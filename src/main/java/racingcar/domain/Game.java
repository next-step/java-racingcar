package racingcar.domain;

import java.util.List;

public class Game {
    private final Cars cars;

    public Game(final Cars cars) {
        this.cars = cars;
    }

    public void play() {
        cars.allMove();
    }

    public List<Car> getWinner() {
        return cars.getHighestCars();
    }
}
