package racewinner.domain;

import racewinner.domain.strategy.MoveStrategy;
import racewinner.exception.NegativeNumberException;
import java.util.List;

public class CarRacing {
    private final Cars cars;
    private int remainCount;
    private MoveStrategy moveStrategy;

    public CarRacing(Cars cars, int raceAttemptCount, MoveStrategy moveStrategy) {
        this.cars = cars;

        negativeNumberCheck(raceAttemptCount);
        this.remainCount = raceAttemptCount;
        this.moveStrategy = moveStrategy;
    }

    private void negativeNumberCheck(final int raceAttemptCount) {
        if (raceAttemptCount < 0) {
            throw new NegativeNumberException();
        }
    }

    public void race() {
        this.remainCount--;
        cars.move(moveStrategy);
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
