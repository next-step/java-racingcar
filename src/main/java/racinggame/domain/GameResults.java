package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class GameResults {
    private final List<GameResult> results;
    private final List<String> winners;

    public GameResults(List<Car> cars) {
        this.results = new ArrayList<>();
        this.winners = new ArrayList<>();
        saveResults(cars);
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

    private void saveResults(List<Car> cars) {
        for (Car car : cars) {
            GameResult gameResult = new GameResult(car.getName(), car.getPosition());
            this.results.add(gameResult);
        }
    }

    public void saveWinners(Car car) {
        winners.add(car.getName());
    }

}
