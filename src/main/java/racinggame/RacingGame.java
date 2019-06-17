package racinggame;

public class RacingGame {
    private int currentRound = 0;
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
        this.currentRound += 1;
        for (Car car : this.carLists.getCarList()) {
            if (CarHandler.getRandomMoveCondition()) {
                car.move();
            }
        }
    }

    public void playFullRound() {
        while (this.currentRound < this.racingGameParameters.getGameRound()) {
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
