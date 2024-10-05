package racinggame.domain.collection;

import racinggame.domain.Car;
import racinggame.domain.GameResult;

import java.util.ArrayList;
import java.util.List;

public class GameResults {
    private final List<GameResult> results;
    private final List<String> winners;

    public GameResults(Cars cars) {
        this.results = new ArrayList<>();
        this.winners = new ArrayList<>();
        saveResults(cars);
    }

    public int carCount() {
        return results.size();
    }

    public int getGameResultCarPositionByIndex(int index) {
        return results.get(index).getCarPosition();
    }

    public String getGameResultCarNameByIndex(int index) {
        return results.get(index).getCarName();
    }

    public List<String> getWinners() {
        return winners;
    }

    private void saveResults(Cars cars) {
        for (Car car : cars.getCarList()) {
            GameResult gameResult = new GameResult(car.getName(), car.getPosition());
            this.results.add(gameResult);
        }
    }

    public void saveWinners(Car car) {
        winners.add(car.getName());
    }
}
