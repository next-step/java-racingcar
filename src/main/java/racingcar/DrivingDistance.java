package racingcar;

public class DrivingDistance {

    public static final int INIT_VALUE = 0;
    private final int drivingDistance;

    public DrivingDistance(int drivingDistance) {
        this.drivingDistance = drivingDistance;
    }

    public DrivingDistance() {
        this(INIT_VALUE);
    }

    public int value() {
        return drivingDistance;
    }

    public DrivingDistance moveForward() {
        return new DrivingDistance(drivingDistance + 1);
    }

    public boolean matchDistance(int distance) {
        return drivingDistance == distance;
    }
}
