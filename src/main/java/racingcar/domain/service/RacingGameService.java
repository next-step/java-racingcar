package racingcar.domain.service;

import racingcar.domain.model.Cars;
import racingcar.domain.strategy.RandomMoveStrategy;

public class RacingGameService {

    private final Cars cars;

    public RacingGameService(Cars cars) {
        this.cars = cars;
    }

    public Cars gameStart(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            cars.moveCars(new RandomMoveStrategy());
        }
        return cars;
    }

}
