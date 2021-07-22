package racingcar;

import java.util.Objects;
import racingcar.common.ErrorMessage;

public class Distance {

    private final int minInitInput = 0;
    private final int minMoveInput = 0;
    private final int distance;

    public Distance(int distance) {
        if (!initValidation(distance)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_INIT_DISTANCE);
        }

        this.distance = distance;
    }

    public Distance move(int moveDistance) {
        if (!moveValidation(moveDistance)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_MOVE_DISTANCE);
        }

        return new Distance(this.get() + moveDistance);
    }

    public int get() {
        return distance;
    }

    private boolean initValidation(int initDistance) {
        if (initDistance >= minInitInput) {
            return true;
        }

        return false;
    }

    private boolean moveValidation(int moveDistance) {
        if (moveDistance >= minMoveInput) {
            return true;
        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Distance)) {
            return false;
        }
        Distance distance1 = (Distance) o;
        return distance == distance1.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }
}
