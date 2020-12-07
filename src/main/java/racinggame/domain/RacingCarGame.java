package racinggame.domain;

import racinggame.domain.car.CarName;
import racinggame.domain.car.RacingCars;
import racinggame.domain.move.RandomMove;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingCarGame {
    private final List<CarName> carNames;
    private final int gameCount;
    private final Map<Integer, GameResult> gameResults;

    public RacingCarGame(final List<String> names, final int gameCount) {
        this.carNames = names.stream().map(CarName::new).collect(Collectors.toList());
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

    public List<CarName> pickLastWinners() {
        return gameResults.get(gameCount).pickWinners();
    }

    public Map<Integer, GameResult> getGameResults() {
        return gameResults;
    }
}
