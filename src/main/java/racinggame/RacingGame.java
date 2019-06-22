package racinggame;

public class RacingGame {
    private final GameResults gameResults;
    private final MoveDecider moveDecider;
    private Cars cars;
    private GameRound gameRound;

    public RacingGame(RacingGameParameters racingGameParameters) {
        this.cars = new Cars(racingGameParameters.getCarNames());
        this.gameRound = new GameRound(racingGameParameters.getGameRound());
        this.gameResults = new GameResults();
        this.moveDecider = racingGameParameters.getMoveDecider();

        this.gameResults.addResult(new GameResult(cars));
    }

    private GameResult playRound() {
        cars = this.cars.moveCarsByDecider(moveDecider);
        gameRound = gameRound.nextRound();
        return new GameResult(cars);
    }

    public GameResults playFullRound() {
        while (!gameRound.isFinished()) {
            GameResult gameResult = playRound();
            gameResults.addResult(gameResult);
        }
        return gameResults;
    }

    public GameResults getGameResults() {
        return this.gameResults;
    }
}
