package racingcar.domain;

import racingcar.strategy.MovingStrategy;

import java.util.List;

public class Race {
    private final Cars cars;

    public Race(Cars cars) {
        this.cars = cars;
    }

    public List<Car> playRace(MovingStrategy movingStrategy) {
        return cars.move(movingStrategy);
    }

    public List<Car> findWinners() {
        return cars.findWinners();
    }
}
