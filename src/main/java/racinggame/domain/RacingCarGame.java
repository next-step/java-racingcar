package racinggame.domain;

import racinggame.domain.car.RacingCars;
import racinggame.domain.move.RandomMove;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingCarGame {
    private final List<String> carNames;
    private final int gameCount;
    private final Map<Integer, GameResult> gameResults;

    public RacingCarGame(final List<String> carNames, final int gameCount) {
        this.carNames = carNames;
        this.gameCount = gameCount;
        this.gameResults = new HashMap<>();
    }

    public void gameStart() {
        RacingCars racingCars = RacingCars.of(carNames);
        for (int index = 1; index <= gameCount; index++) {
            racingCars = racingCars.move(new RandomMove());
            gameResults.put(index, new GameResult(racingCars.getRacingCars()));
        }
    }

    public Map<Integer, GameResult> getGameResults() {
        return gameResults;
    }
}
