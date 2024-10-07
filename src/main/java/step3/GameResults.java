package step3;

import java.util.ArrayList;
import java.util.List;

public class GameResults {

    private final List<List<Integer>> gameResult;

    public GameResults(List<List<Integer>> gameResult) {
        this.gameResult = gameResult;
    }

    public void saveGameResults(Cars cars) {
        List<Integer> roundResult = new ArrayList<>();
        for (Car car : cars.getCars()) {
            roundResult.add(car.showDistance());
        }
        gameResult.add(roundResult);
    }

    public List<List<Integer>> showGameResults() {
        return gameResult;
    }
}
