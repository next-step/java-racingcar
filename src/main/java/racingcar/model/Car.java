package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private static final int MOVE_BOUNDARY_VALUE = 4;
    private int moveDistance;
    private List<Integer> moveDistanceTrace;

    Car(int moveDistance) {
        if (moveDistance < 0) {
            throw new RuntimeException("음수 입력값은 허용하지 않습니다.");
        }
        this.moveDistance = moveDistance;
        this.moveDistanceTrace = new ArrayList<>();
    }

    public List<Integer> getMoveDistanceTrace() {
        return this.moveDistanceTrace;
    }

    public void tryToMove(int randomValue) {
        if (randomValue >= MOVE_BOUNDARY_VALUE) {
            this.moveDistance++;
            this.moveDistanceTrace.add(this.moveDistance);
            return;
        }
        this.moveDistanceTrace.add(this.moveDistance);
    }
}
