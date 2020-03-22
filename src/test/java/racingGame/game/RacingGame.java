package racingGame.game;

import racingGame.car.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final RacingGameRule racingGameRule;
    private GameParticipants gameParticipants;
    private TotalGameResult totalGameResult;
    private int gameCount;

    public RacingGame(RacingGameRule racingGameRule) {
        this.racingGameRule = racingGameRule;
    }

    public void participate(int carCount, int gameCount) {
        verifyRegister(carCount, gameCount);
        this.gameParticipants = register(carCount);
        this.gameCount = gameCount;
    }

    private void verifyRegister(int carCount, int gameCount) {
        if (carCount < 0 || gameCount < 0) {
            throw new IllegalArgumentException();
        }
    }

    private GameParticipants register(int carCount) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
        return new GameParticipants(carList);
    }

    public void start() {
        List<GameResult> result = new ArrayList<>();
        for (int i = 0; i < gameCount; i++) {
            gameParticipants.gameStart(racingGameRule);
            result.add(gameParticipants.getGameResult());
        }
        totalGameResult = new TotalGameResult(result);
    }

    public TotalGameResult getTotalGameResult() {
        if (totalGameResult == null) {
            throw new IllegalArgumentException();
        }
        return totalGameResult;
    }
}
