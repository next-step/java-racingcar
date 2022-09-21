package racingcar.domain;

import java.util.List;

public class RaceGame {
    private Cars cars;
    private final MoveStrategy moveStrategy;

    public RaceGame(Cars cars) {
        this.cars = cars;
        this.moveStrategy = new RandomMoveStrategy();
    }

    public RaceGame(Cars cars, MoveStrategy moveStrategy) {
        this.cars = cars;
        this.moveStrategy = moveStrategy;
    }

    public void race() {
        cars = cars.move(moveStrategy);
    }

    public int joinCount() {
        return cars.size();
    }

    public List<Car> getCars() {
        return cars.getCars();
    }
}
