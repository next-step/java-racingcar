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
        Round finalRound = round;
        Round currentRound = Round.init();

        while (!finalRound.isOver()) {
            cars.move();
            cars.recode(currentRound.nextRound(), gameLog);
            finalRound = finalRound.play();
            currentRound = currentRound.nextRound();
        }
        return gameLog;
    }

}
