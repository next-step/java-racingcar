package carracing.domain;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame {
    private final CarList cars;
    private final NumberGenerator randomNumberGenerator;
    private final int gameCount;

    public CarRacingGame(String carNameString, int gameCount, NumberGenerator numberGenerator) {
        this.cars = new CarList(carNameString);
        this.gameCount = validateGameCount(gameCount);
        randomNumberGenerator = numberGenerator;
    }

    private int validateGameCount(int gameCount) {
        if (gameCount <= 0) {
            throw new IllegalArgumentException("게임 횟수는 0보다 커야 합니다.");
        }
        return gameCount;
    }

    public GameResult playGame() {
        List<List<String>> result = new ArrayList<>();
        result.add(cars.playOneRound(() -> 0));
        for (int i = 0; i < gameCount; ++i) {
            result.add(cars.playOneRound(randomNumberGenerator));
        }
        return new GameResult(result, cars.findWinners());
    }
}
