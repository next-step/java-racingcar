package racinggame;

public class RacingGame {
    private final GameResults gameResults;
    private Cars cars;
    private GameRound gameRound;
    private MoveDecider moveDecider;

    public RacingGame(RacingGameParameters racingGameParameters) {
        this.cars = new Cars(racingGameParameters.getCarNames());
        this.gameRound = new GameRound(racingGameParameters.getGameRound());
        this.gameResults = new GameResults();
        this.saveCurrentResult();
        this.moveDecider = racingGameParameters.getMoveDecider();
    }

    private void playRound() {
        cars = cars.moveCarsByDecider(moveDecider);
        gameRound = gameRound.increaseCurrentRound();
    }

    public GameResults playFullRound() {
        while (!gameRound.isFinished()) {
            playRound();
            saveCurrentResult();
        }
        return gameResults;
    }

    private void saveCurrentResult() {
        GameResult gameResult = new GameResult(this.cars);
        this.gameResults.getGameResults().add(gameResult);
    }

    public GameResults getGameResults() {
        return this.gameResults;
    }
}
