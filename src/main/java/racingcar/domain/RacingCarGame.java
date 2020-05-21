package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    private final Cars cars;
    private final int moveCount;
    List<String> gameResults = new ArrayList<>();

    public RacingCarGame(String carNames, int moveCount) {
        this.cars = Cars.createCars(carNames);
        this.moveCount = moveCount;
    }

    public Cars getCars() {
        return cars;
    }

    public void execute(Strategy strategy) {
        for (int i = 0; i < moveCount; i++) {
            GameResult gameResult = new GameResult(cars);
            cars.carRacing(strategy);
            gameResults.add(gameResult.getResult());
        }
    }

    public Cars getWinners() {
        return cars.getWinners();
    }

    public List<String> getGameResults() {
        return gameResults;
    }
}

