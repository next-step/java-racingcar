package racingcar.domain;

public class DrivingDistance {

    private final int value;

    private static final int INIT_VALUE = 0;

    public DrivingDistance() {
        this(INIT_VALUE);
    }

    public DrivingDistance(int value) {
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
}
