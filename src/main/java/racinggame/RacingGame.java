package racinggame;

public class RacingGame {
    private final Cars cars;
    private final GameRound gameRound;
    private final GameResults gameResults;

    public RacingGame(RacingGameParameters racingGameParameters) {
        this.cars = new Cars(racingGameParameters.getCarNames());
        this.gameRound = new GameRound(racingGameParameters.getGameRound());
        this.gameResults = new GameResults();
        this.saveCurrentResult();
    }

    private void playRound() {
        cars.moveCarsByRandomCondition();
        gameRound.increaseCurrentRound();
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
