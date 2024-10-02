package racing.domain;

import racing.model.RoundResult;
import racing.model.collection.Cars;
import racing.model.collection.GameResult;

public class RacingGame {

    private final int roundCount;

    private final Cars cars;

    private RacingGame(int roundCount, Cars cars) {
        this.roundCount = roundCount;
        this.cars = cars;
    }

    public int getRoundCount() {
        return roundCount;
    }

    public Cars getCars() {
        return cars;
    }

    public GameResult start() {
        GameResult gameResult = new GameResult();
        for (int i = 0; i < roundCount; i++) {
            playRound(gameResult);
        }
        return gameResult;
    }

    private void playRound(GameResult gameResult) {
        cars.moveCars();
        RoundResult roundResult = cars.getRoundResult();
        gameResult.addRoundResult(roundResult);
    }

    public static RacingGame setUp(int roundCount, Cars cars) {
        return new RacingGame(roundCount, cars);
    }
}
