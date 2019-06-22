package racinggame;

public class RacingGame {
    private final GameResults gameResults;
    private Cars cars;
    private GameRound maxRound;
    private MoveDecider moveDecider;

    public RacingGame(RacingGameParameters racingGameParameters) {
        this.cars = new Cars(racingGameParameters.getCarNames());
        this.maxRound = new GameRound(racingGameParameters.getGameRound());
        this.gameResults = new GameResults();
        this.saveCurrentResult();
        this.moveDecider = racingGameParameters.getMoveDecider();
    }

    private void playRound() {
        cars = cars.moveCarsByDecider(moveDecider);
        maxRound = maxRound.increaseCurrentRound();
    }

    public GameResults playFullRound() {
        while (!maxRound.isFinished()) {
            playRound();
            saveCurrentResult();
        }
        return gameResults;
    }

    private void saveCurrentResult() {
        GameResult gameResult = new GameResult(this.cars);
        gameResults.addResult(gameResult);
    }

    public GameResults getGameResults() {
        return this.gameResults;
    }
}
