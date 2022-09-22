package racingcar.service;

import racingcar.domain.*;
import racingcar.repository.RacingCarTable;

import java.util.List;

public class RacingGame {
    private final RacingCarTable carTable;
    private final MoveStrategy moveStrategy;

    public RacingGame(RacingCarTable racingCarTable) {
        this.carTable = racingCarTable;
        moveStrategy = new RandomMoveStrategy();
    }

    public RacingGame(RacingCarTable racingCarTable, MoveStrategy moveStrategy) {
        this.carTable = racingCarTable;
        this.moveStrategy = moveStrategy;
    }

    public void join(int numberOfCars) {
        join(CarFactory.createCars(numberOfCars));
    }

    public void join(Cars cars) {
        carTable.saveAll(cars);
    }

    public RacingGameResult race(int tryCount) {
        RacingGameResult result = new RacingGameResult();

        Cars cars = carTable.findAll();
        result.record(cars);
        for (int i = 0; i < tryCount; i++) {
            cars.move(moveStrategy);
            result.record(cars);
        }

        return result;
    }

    public int joinCount() {
        return carTable.findAll()
                        .size();
    }

    public List<Car> getCars() {
        return carTable.findAll()
                        .getCars();
    }
}
