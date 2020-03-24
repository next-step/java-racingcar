package racingcar.domain;

import racingcar.infrastructure.DefaultMoveStrategy;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private int round;

    public RacingGame(List<String> carNames, int round) {
        this.cars = new Cars(carNames);
        this.round = round;
    }

    public Cars roundStart() {
        return cars.moveAllCar(new DefaultMoveStrategy());
    }

    public int getRound() {
        return round;
    }
}
