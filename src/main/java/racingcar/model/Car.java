package racingcar.model;

import racingcar.pattern.ValueGenerateStrategy;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private static final int MOVE_BOUNDARY_VALUE = 4;
    private Identity id;
    private PositiveNumber moveDistance;
    private List<PositiveNumber> moveDistanceTrace;

    Car(int moveDistance, String id) {
        this.id = new Identity(id);
        this.moveDistance = new PositiveNumber(moveDistance);
        this.moveDistanceTrace = new ArrayList<>();
        if (moveDistance > 0) {
            this.moveDistanceTrace.add(new PositiveNumber(this.moveDistance.getNumber()));
        }
    }

    public List<PositiveNumber> getMoveDistanceTrace() {
        return this.moveDistanceTrace;
    }

    public Identity getId() {
        return this.id;
    }

    public PositiveNumber getMoveDistance() {
        return this.moveDistance;
    }

    public void tryToMove(ValueGenerateStrategy valueGenerateStrategy) {
        if (new PositiveNumber(valueGenerateStrategy.generate()).isGreaterThanOrEqual(MOVE_BOUNDARY_VALUE)) {
            this.moveDistance.add(new PositiveNumber(1));
            this.moveDistanceTrace.add(new PositiveNumber(this.moveDistance.getNumber()));
            return;
        }
        this.moveDistanceTrace.add(new PositiveNumber(this.moveDistance.getNumber()));
    }
}
