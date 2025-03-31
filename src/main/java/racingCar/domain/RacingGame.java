package racingCar.domain;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {
    private final Cars cars;
    private final MoveStrategy moveStrategy;

    public RacingGame(Cars cars, MoveStrategy moveStrategy) {
        this.cars = cars;
        this.moveStrategy = moveStrategy;
    }

    public void playRound() {
        cars.moveAll(moveStrategy);
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public List<Car> findWinners() {
        return cars.findWinners();
    }

}
