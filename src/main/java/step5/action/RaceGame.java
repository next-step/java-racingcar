package step5.action;

import step5.domain.Cars;
import step5.domain.strategy.MoveStrategy;

public class RaceGame {
    private final Cars cars;

    private RaceGame(Cars cars) {
        this.cars = cars;
    }

    public static RaceGame of(Cars cars) {
        return new RaceGame(cars);
    }

    public Cars getCars() {
        return cars;
    }

    public void move(MoveStrategy strategy) {
        cars.move(strategy);
    }
}
