package racingcar.vehicle;

import java.util.Objects;
import racingcar.common.exception.InvalidInitDistanceException;
import racingcar.common.exception.InvalidMoveDistanceException;

public class Distance implements Comparable<Distance> {

    private static final int MIN_INIT_INPUT = 0;
    private static final int MIN_MOVE_INPUT = 0;

    private final int distance;

    public Distance(int distance) {
        if (!initValidation(distance)) {
            throw new InvalidInitDistanceException();
        }

        this.distance = distance;
    }

    public Distance move(int moveDistance) {
        if (!moveValidation(moveDistance)) {
            throw new InvalidMoveDistanceException();
        }

        return new Distance(this.get() + moveDistance);
    }

    public int get() {
        return distance;
    }

    private boolean initValidation(int initDistance) {
        if (initDistance >= MIN_INIT_INPUT) {
            return true;
        }

        return false;
    }

    private boolean moveValidation(int moveDistance) {
        if (moveDistance >= MIN_MOVE_INPUT) {
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

    @Override
    public int compareTo(Distance o) {
        if (this.distance > o.distance) {
            return 1;
        }

        return -1;
    }
}
