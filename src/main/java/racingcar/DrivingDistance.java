package racingcar;

public class DrivingDistance {

    public static final int INIT_VALUE = 0;
    private int drivingDistance;

    public DrivingDistance(int drivingDistance) {
        this.drivingDistance = drivingDistance;
    }

    public DrivingDistance() {
        this(INIT_VALUE);
    }

    public int value() {
        return drivingDistance;
    }

    public void moveForward() {
        drivingDistance++;
    }

    public boolean matchDistance(int distance) {
        return drivingDistance == distance;
    }
}
