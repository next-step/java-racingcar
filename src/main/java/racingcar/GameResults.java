package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameResults {
    private List<List<Car>> steps;

    private GameResults() {
        steps = new ArrayList<>();
    }

    public void addStep(List<Car> cars) {
        steps.add(cars);
    }

    public List<List<Car>> getSteps() {
        return this.steps;
    }

    public static GameResults createResult() {
        return new GameResults();
    }
}
