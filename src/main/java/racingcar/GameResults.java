package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameResults {
    private List<List<Integer>> steps;

    private GameResults() {
        steps = new ArrayList<>();
    }

    public void addStep(List<Integer> positions) {
        steps.add(positions);
    }

    public List<List<Integer>> getSteps() {
        return this.steps;
    }

    public static GameResults createResult() {
        return new GameResults();
    }
}
