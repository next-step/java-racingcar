package racingcar.car;

import racingcar.strategy.MoveStrategy;

import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final MoveStrategy moveStrategy;

    public RacingGame(Cars cars, MoveStrategy moveStrategy) {
        this.cars = cars;
        this.moveStrategy = moveStrategy;
    }

    public void race() {
        cars.move(moveStrategy);
    }

    public List<Car> getCars() {
        return cars.cars();
    }

    public List<Car> getRaceWinners() {
        return cars.getRaceWinners();
    }

}
