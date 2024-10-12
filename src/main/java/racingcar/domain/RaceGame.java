package racingcar.domain;

import java.util.List;

public class RaceGame {

    private final List<Car> cars;
    private final int tryCount;

    public RaceGame(List<Car> cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public void moveCars(final MoveStrategy moveStrategy) {
        for (Car car : cars) {
            car.move(moveStrategy);
        }
    }
}
