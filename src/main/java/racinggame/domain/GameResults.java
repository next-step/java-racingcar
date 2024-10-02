package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class GameResults {
    private final List<GameResult> results;

    public GameResults() {
        this.results = new ArrayList<>();
    }

    public int carCount() {
        return results.size();
    }

    public GameResult getGameResult(int index) {
        return results.get(index);
    }

    public void save(List<Car> cars) {
        for (Car car : cars) {
            this.results.add(new GameResult(car.getName(), car.getPosition()));
        }
    }

}
