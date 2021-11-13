package racingcar.domain;

public class RacingGame {
    private final Cars cars;
    private final GameLog gameLog;

    private RacingGame(Cars cars) {
        this.cars = cars;
        this.gameLog = GameLog.init();
    }

    public static RacingGame of(Cars cars) {
        return new RacingGame(cars);
    }

    public GameLog play(TryCount tryCount) {
        while (tryCount.nonOver()) {
            tryCount.counting();
            cars.move();
            cars.recode(tryCount.currentRound(), gameLog);
        }
        return gameLog;
    }

}
