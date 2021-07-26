package racingcargame.domain.common;

import java.util.Objects;
import racingcargame.domain.common.exception.InvalidInitDistanceException;

public class Distance implements Comparable<Distance> {

    private static final int INIT_INPUT_MIN = 0;

    private final int distance;

    public Distance(int distance) {
        initValidation(distance);
        this.distance = distance;
    }

    private void initValidation(int initDistance) {
        if (initDistance < INIT_INPUT_MIN) {
            throw new InvalidInitDistanceException();
        }
    }

    public Distance forward(Distance forwordDistance) {
        return new Distance(distance + forwordDistance.getValue());
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

