package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class GameResults {
    private final List<GameResult> results;
    private final List<String> winners;

    public GameResults() {
        this.results = new ArrayList<>();
        this.winners = new ArrayList<>();
    }

    public int carCount() {
        return results.size();
    }

    public GameResult getGameResult(int index) {
        return results.get(index);
    }

    public List<String> getWinners() {
        return winners;
    }

    public void save(List<Car> cars) {
        updateWinners(cars);
        saveResults(cars);
    }

    private void updateWinners(List<Car> cars) {
        winners.clear();
        int maxPosition = findMaxPosition(cars);
        for (Car car : cars) {
            if (car.isEqualPosition(maxPosition)) {
                winners.add(car.getName());
            }
        }
    }

    private int findMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private void saveResults(List<Car> cars) {
        for (Car car : cars) {
            GameResult gameResult = new GameResult(car.getName(), car.getPosition());
            this.results.add(gameResult);
        }
    }

}
