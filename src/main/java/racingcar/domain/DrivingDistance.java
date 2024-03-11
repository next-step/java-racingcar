package racingcar.domain;

import java.util.Objects;

public class DrivingDistance {

    private final int value;

    private static final int INIT_VALUE = 0;

    public DrivingDistance() {
        this(INIT_VALUE);
    }

    public DrivingDistance(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("주행거리는 양수만 올 수 있습니다");
        }
        this.value = value;
    }

    public int value() {
        return value;
    }

    public DrivingDistance moveForward() {
        return new DrivingDistance(value + 1);
    }

    public boolean matchDistance(int distance) {
        return value == distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DrivingDistance that = (DrivingDistance) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
