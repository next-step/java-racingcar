package racingcar;

public class DrivingDistance {

    public static final int INIT_DISTANCE = 0;
    private int drivingDistance;

    public DrivingDistance(int drivingDistance) {
        this.drivingDistance = drivingDistance;
    }

    public DrivingDistance() {
        this(INIT_DISTANCE);
    }

    public int getDrivingDistance() {
        return drivingDistance;
    }

    public void moveForward() {
        drivingDistance++;
    }

    public boolean matchDistance(int distance) {
        return drivingDistance == distance;
    }
}
