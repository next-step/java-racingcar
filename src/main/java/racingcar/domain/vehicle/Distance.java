package racingcar.domain.vehicle;

import java.util.Objects;
import racingcar.common.exception.InvalidInitDistanceException;
import racingcar.common.exception.InvalidMoveDistanceException;

public class Distance implements Comparable<Distance> {

    private static final int MIN_INIT_INPUT = 0;
    private static final int MIN_MOVE_INPUT = 0;

    private final int distance;

    public Distance(int distance) {
        initValidation(distance);
        this.distance = distance;
    }

    private void initValidation(int initDistance) {
        if (initDistance < MIN_INIT_INPUT) {
            throw new InvalidInitDistanceException();
        }
    }

    public Distance move(int moveDistance) {
        moveValidation(moveDistance);
        return new Distance(distance + moveDistance);
    }

    private void moveValidation(int moveDistance) {
        if (moveDistance < MIN_MOVE_INPUT) {
            throw new InvalidMoveDistanceException();
        }
    }

    public int getValue() {
        return distance;
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

    @Override
    public int compareTo(Distance o) {
        return Integer.compare(this.distance, o.distance);
    }
}
