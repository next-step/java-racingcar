package game.racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameResult {

    private final List<Car> cars;

    public GameResult(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> getCurrentStates() {
        List<String> gameResults = new ArrayList<>(cars.size());
        for (Car car : cars) {
            gameResults.add(car.getCurrentState());
        }
        return gameResults;
    }

    public List<String> getWinnerNames() {
        final int maxMoveCount = findMaxMoveCount(cars);

        return cars.stream()
                .filter(car -> car.isSameMoveCount(maxMoveCount))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int findMaxMoveCount(List<Car> cars) {
        int maxMoveCount = 0;

        for (Car car : cars) {
            maxMoveCount = car.maxMoveCount(maxMoveCount);
        }

        return maxMoveCount;
    }

}
