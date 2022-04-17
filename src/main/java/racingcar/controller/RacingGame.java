package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.factory.CarsFactory;
import racingcar.view.dto.RacingResult;

public class RacingGame {
    private static final String DEFAULT_CAR_NAMES = "car";
    private final int tryCount;
    private final Cars cars;

    private int movedCount = 0;

    public RacingGame(int tryCount) {
        this(tryCount, DEFAULT_CAR_NAMES);
    }

    public RacingGame(int tryCount, String carNames) {
        this.tryCount = tryCount;
        this.cars = CarsFactory.create(carNames);
    }

    public boolean end() {
        return this.movedCount >= this.tryCount;
    }

    public RacingResult race() {
        this.cars.move();
        increaseMovedCount();

        return new RacingResult(cars);
    }

    private synchronized void increaseMovedCount() {
        this.movedCount++;
    }
}
