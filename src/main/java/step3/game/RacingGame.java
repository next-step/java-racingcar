package step3.game;

import step3.random.RandomStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGame {
    private List<Car> cars;
    private final List<List<GameHistory>> result = new ArrayList<>();
    private final int moveCount;
    private final RandomStrategy random;

    public RacingGame(int moveCount, RandomStrategy random, List<Car> cars) {
        this.random = random;
        this.moveCount = moveCount;
        this.cars = cars;
    }

    public List<List<GameHistory>> start() {
        for (int i = 0; i < moveCount; i++) {
            moveCars();
            saveCurrentCarPositions(i);
        }
        return result;
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move(random());
        }
    }

    private int random() {
        return random.generateRandomValue();
    }

    private void saveCurrentCarPositions(int index) {
        result.add(new ArrayList<>());
        for (Car car : cars) {
            result.get(index).add(new GameHistory(car.getName(), car.getPosition()));
        }
    }

    public List<String> getCurrentWinners() {
        if (result.isEmpty()) {
            return Collections.emptyList();
        }

        List<String> winners = new ArrayList<>();
        int max = 0;
        for (GameHistory history : result.get(result.size() - 1)) {
            if (history.getPosition() > max) {
                max = history.getPosition();
                winners.clear();
                winners.add(history.getName());
            } else if (history.getPosition() == max) {
                winners.add(history.getName());
            }
        }
        return winners;
    }
}
