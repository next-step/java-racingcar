package racinggame;

public class RacingGame {
    private CarLists carLists;
    private RacingGameParameters racingGameParameters;
    private GameResults gameResults;

    public RacingGame(RacingGameParameters racingGameParameters) {
        this.racingGameParameters = racingGameParameters;
        this.carLists = new CarLists(racingGameParameters.getCarQuantity());
        this.gameResults = new GameResults();
        this.saveCurrentResult();
    }

    private void playRound() {
        for (Car car : this.carLists.getCarList()) {
            if (CarHandler.getRandomMoveCondition()) {
                car.move();
            }
        }
        racingGameParameters.increaseCurrentRound();
    }

    public void playFullRound() {
        while (!racingGameParameters.isFinished()) {
            playRound();
            saveCurrentResult();
        }
    }

    private void saveCurrentResult() {
        GameResult gameResult = new GameResult(this.carLists);
        this.gameResults.addRoundResult(gameResult);
    }

    public GameResults getGameResults() {
        return this.gameResults;
    }
}
