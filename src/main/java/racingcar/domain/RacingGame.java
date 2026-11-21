package racingcar.domain;

import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final AttemptCount attemptCount;

    public RacingGame(Cars cars, int attemptCount) {
        this(cars, new AttemptCount(attemptCount));
    }

    public RacingGame(Cars cars, AttemptCount attemptCount) {
        this.cars = cars;
        this.attemptCount = attemptCount;
    }

    public Cars playRound(MoveStrategy strategy) {
        cars.moveCars(strategy);
        attemptCount.decrease();
        return cars;
    }

    public boolean isFinished() {
        return !attemptCount.hasRemaining();
    }

    public List<Car> findWinners() {
        return cars.findWinners();
    }
}
