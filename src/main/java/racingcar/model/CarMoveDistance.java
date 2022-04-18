package racingcar.model;

import java.util.List;

public class CarMoveDistance {
    private List<PositiveNumber> moveDistanceTrace;

    public CarMoveDistance(List<PositiveNumber> moveDistanceTrace) {
        this.moveDistanceTrace = moveDistanceTrace;
    }

    public List<PositiveNumber> getMoveDistanceTrace() {
        return this.moveDistanceTrace;
    }
}
