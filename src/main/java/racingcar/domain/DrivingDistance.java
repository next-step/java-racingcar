package racingcar.domain;

import java.util.Objects;

public class DrivingDistance {

    private static final int INIT_VALUE = 0;

    private final int value;

    public DrivingDistance() {
        this(INIT_VALUE);
    }

    private DrivingDistance(int value) {
        this.value = value;
    }

    public static DrivingDistance of(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("주행거리는 양수만 올 수 있습니다");
        }
        return new DrivingDistance(value);
    }

    public DrivingDistance moveForward() {
        return new DrivingDistance(value + 1);
    }

    public boolean matchDistance(int distance) {
        return value == distance;
    }

    public int value() {
        return value;
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
