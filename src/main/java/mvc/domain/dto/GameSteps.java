package mvc.domain.dto;

import java.util.ArrayList;
import java.util.List;

public class GameSteps {
    private final List<StateOfCarsList> steps;

    private GameSteps() {
        steps = new ArrayList<>();
    }

    public void addStep(StateOfCarsList step) {
        steps.add(step);
    }

    public List<StateOfCarsList> getSteps() {
        return this.steps;
    }

    public static GameSteps createSteps() {
        return new GameSteps();
    }
}
