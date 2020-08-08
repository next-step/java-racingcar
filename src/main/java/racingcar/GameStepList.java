package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameStepList {
    private final List<GameStep> steps;

    private GameStepList() {
        steps = new ArrayList<>();
    }

    public void addStep(GameStep step) {
        steps.add(step);
    }

    public List<GameStep> getSteps() {
        return this.steps;
    }

    public static GameStepList createSteps() {
        return new GameStepList();
    }
}
