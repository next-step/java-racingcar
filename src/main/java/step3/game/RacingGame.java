package step3.game;

import step3.random.RandomStrategy;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final List<GameRound> result = new ArrayList<>();
    private final int moveCount;
    public RacingGame(int moveCount, List<Car> cars) {
        this.moveCount = moveCount;
        this.cars = cars;
    }

    public List<GameRound> start(RandomStrategy random) {
        for (int i = 0; i < moveCount; i++) {
            moveCars(random);
        }
        return result;
    }

    private void moveCars(RandomStrategy random) {
        for (Car car : cars) {
            car.move(random.generateRandomValue());
        }
        result.add(new GameRound(cars));
    }
}
