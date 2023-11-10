package racewinner.domain;

import racewinner.exception.NegativeNumberException;
import racewinner.util.RandomGenerator;

import java.util.List;

public class CarRacing {
    private final Cars cars;
    private int remainCount;
    private RandomGenerator generator;

    public CarRacing(Cars cars, int raceAttemptCount, RandomGenerator generator) {
        this.cars = cars;

        negativeNumberCheck(raceAttemptCount);
        this.remainCount = raceAttemptCount;
        this.generator = generator;
    }

    private void negativeNumberCheck(final int raceAttemptCount) {
        if (raceAttemptCount < 0) {
            throw new NegativeNumberException();
        }
    }

    public void race() {
        this.remainCount--;
        cars.move(generator);
    }

    public boolean isFinished() {
        return remainCount == 0;
    }

    public List<String> findWinners() {
        return cars.findWinner();
    }

    @Override
    public String toString() {
        return cars.toString();
    }
}
