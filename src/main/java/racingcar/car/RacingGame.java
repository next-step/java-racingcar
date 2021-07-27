package racingcar.car;

import racingcar.strategy.MoveStrategy;

import java.util.Collections;
import java.util.List;

public class RacingGame {

    private final Cars cars;

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public void race(MoveStrategy moveStrategy) {
        cars.move(moveStrategy);
    }

    public List<Car> getCars() {
        return cars.cars();
    }

    public List<Car> getRaceWinners() {
        return Collections.unmodifiableList(cars.getRaceWinners());
    }

}
