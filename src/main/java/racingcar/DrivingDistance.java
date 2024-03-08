package racingcar;

public class DrivingDistance {

    private int drivingDistance = 0;

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
