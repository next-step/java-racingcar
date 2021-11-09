package racingcar.domain;

public class RacingGame {
    private final Cars cars;
    private final TryCount tryCount;

    private RacingGame(Cars cars, TryCount tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public static RacingGame of(Cars cars, TryCount tryCount) {
        return new RacingGame(cars, tryCount);
    }

    public void play() {
        tryCount.counting();
        cars.move();
    }

    public boolean nonOver() {
        return tryCount.nonOver();
    }
}
