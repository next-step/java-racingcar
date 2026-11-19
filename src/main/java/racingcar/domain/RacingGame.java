package racingcar.domain;


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

    public Cars playRound(RandomMoveStrategy strategy) {
        cars.moveCars(strategy);
        attemptCount.decrease();
        return cars;
    }

    public boolean isFinished() {
        return !attemptCount.hasRemaining();
    }
}
