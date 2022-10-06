package racingcar.domain;

import exception.NegativeNumberException;
import racingcar.dto.RacingRecord;
import racingcar.strategy.MovingStrategy;

import java.util.List;

public class RacingCarGame {
    private static final int ZERO = 0;

    private final int tryCount;
    private final Cars cars;
    private final RacingRecord racingRecord = new RacingRecord();

    public RacingCarGame(String carNames, int tryCount) {
        this.tryCount = validatePositiveNumber(tryCount);
        this.cars = new Cars(carNames);
    }

    public RacingRecord play(MovingStrategy movingStrategy) {
        for (int i = 0; i < tryCount; i++) {
            racingRecord.add(cars.move(movingStrategy));
        }
        return racingRecord;
    }

    public List<Car> finish() {
        return cars.findWinners();
    }

    private int validatePositiveNumber(int value) {
        if (value < ZERO) {
            throw new NegativeNumberException();
        }
        return value;
    }
}
