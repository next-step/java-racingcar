package mvc.domain.dto;

import java.util.ArrayList;
import java.util.List;

public class GameSteps {
    private final List<StateOfCars> steps;

    private GameSteps() {
        steps = new ArrayList<>();
    }

    public void addStep(StateOfCars step) {
        steps.add(step);
    }

    public List<StateOfCars> getSteps() {
        return this.steps;
    }

    public static GameSteps createSteps() {
        return new GameSteps();
    }
}
