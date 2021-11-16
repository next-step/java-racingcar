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

    public GameLog play(Round round) {
        while (!round.isOver()) {
            round.counting();
            cars.move();
            cars.recode(Round.from(round), gameLog);
        }
        return gameLog;
    }

}
