package racingcar.service;

import racingcar.domain.*;

import java.util.List;

public class RacingGame {
    private Cars cars;
    private final MoveStrategy moveStrategy;

    public RacingGame() {
        moveStrategy = new RandomMoveStrategy();
    }

    public RacingGame(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void join(int numberOfCars) {
        this.cars = CarFactory.createCars(numberOfCars);
    }

    public void join(Cars cars) {
        this.cars = cars;
    }

    public RacingGameResult race(int tryCount) {
        RacingGameResult result = new RacingGameResult();

        for (int i = 0; i < tryCount; i++) {
            cars.move(moveStrategy);
            result.record(cars);
        }

        return result;
    }

    public int joinCount() {
        return cars.size();
    }

    public List<Car> getCars() {
        return cars.getCars();
    }
}
