package racingcar;

public class RacingGame {

    private CarMovableDecider carMovableDecider;
    private RacingGameState racingGameState;

    public RacingGame(CarMovableDecider carMovableDecider, RacingGameState racingGameState) {
        this.carMovableDecider = carMovableDecider;
        this.racingGameState = racingGameState;

    }

    public RacingResult race() {
        racingGameState.nextRound();
        racingGameState.move(carMovableDecider);
        return new RacingResult(racingGameState.getCars());
    }

    public boolean isEnd() {
        return racingGameState.isEnd();
    }

    public RacingGameState getRacingGameState() {
        return racingGameState;
    }
}
