package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.factory.CarsFactory;
import racingcar.view.dto.RacingResult;

public class RacingGame {
    private static final String DEFAULT_CAR_NAMES = "car";

    private final int tryCount;
    private final Cars cars;
    private final RacingGameMoveCounter racingGameMoveCounter;

    protected RacingGame(int tryCount) {
        this(tryCount, DEFAULT_CAR_NAMES);
    }

    public RacingGame(int tryCount, String carNames) {
        this.tryCount = tryCount;
        this.cars = CarsFactory.create(carNames);
        this.racingGameMoveCounter = new RacingGameMoveCounter();
    }

    public boolean end() {
        return this.racingGameMoveCounter.isSameOrBiggerThen(tryCount);
    }

    public RacingResult race() {
        this.cars.move();
        racingGameMoveCounter.increase();

        return new RacingResult(cars);
    }
}
