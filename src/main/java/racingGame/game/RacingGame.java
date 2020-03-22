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

    public void participate(String participants, int gameCount) {
        verifyRegister(participants, gameCount);
        this.gameParticipants = register(participants);
        this.gameCount = gameCount;
    }

    private void verifyRegister(String participants, int gameCount) {
        if (participants == null || participants.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (gameCount < 0) {
            throw new IllegalArgumentException();
        }
    }

    private GameParticipants register(String participants) {
        List<Car> carList = new ArrayList<>();
        String[] names = participants.split(",");
        for (String name : names) {
            carList.add(new Car(name));
        }
        return new GameParticipants(carList);
    }

    public void start() {
        List<GameResult> result = new ArrayList<>();
        for (int i = 0; i < gameCount; i++) {
            gameParticipants.gameStart(racingGameRule);
            result.add(gameParticipants.getGameResult());
        }
        recordTotalGameResult(result);
    }

    private void recordTotalGameResult(List<GameResult> result) {
        totalGameResult = new TotalGameResult(gameParticipants.getWinners(), result);
    }

    public TotalGameResult getTotalGameResult() {
        if (totalGameResult == null) {
            throw new IllegalArgumentException();
        }
        return totalGameResult;
    }
}
