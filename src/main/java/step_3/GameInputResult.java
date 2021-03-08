package step_3;

import java.util.ArrayList;
import java.util.List;

public class GameInputResult {
    private final Integer enterCars;
    private final Integer executionCount;

    public Integer enterCars() {
        return this.enterCars;
    }

    public Integer executionCount() {
        return this.executionCount;
    }

    private GameInputResult(Integer enterCars, Integer executionCount) {
        this.enterCars = enterCars;
        this.executionCount = executionCount;
    }

    public static class Builder {
        private final List<Integer> inputValues = new ArrayList<>();
        public void enterValue(Integer value) {
            inputValues.add(value);
        }

        public GameInputResult build() {
            return new GameInputResult(this.inputValues.remove(0), this.inputValues.remove(0));
        }
    }

}
