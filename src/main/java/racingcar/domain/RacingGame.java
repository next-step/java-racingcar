package racingcar.domain;

public class RacingGame {
    private final Cars cars;
    private final TryCount tryCount;
    private final GameLog gameLog;

    private RacingGame(Cars cars, TryCount tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
        this.gameLog = GameLog.init();
    }

    public static RacingGame of(Cars cars, TryCount tryCount) {
        return new RacingGame(cars, tryCount);
    }

    public void play() {
        while (tryCount.nonOver()) {
            tryCount.counting();
            cars.move();
            cars.recode(tryCount.currentRound(), gameLog);
        }
    }

    public boolean nonOver() {
        return tryCount.nonOver();
    }
}
