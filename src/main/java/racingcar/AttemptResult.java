package racingcar;

import java.util.List;

public class AttemptResult {
    private final List<Integer> carPositions;

    public AttemptResult(List<Integer> carPositions) {
        this.carPositions = carPositions;
    }

    public List<Integer> getCarPositions() {
        return this.carPositions;
    }
}
