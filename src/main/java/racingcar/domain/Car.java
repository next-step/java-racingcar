package racingcar.domain;

public class Car {
    public static final int MOVEMENT_DISTANCE_INITIAL_VALUE = 0;

    private int distanceTraveled;

    public Car() {
        distanceTraveled = MOVEMENT_DISTANCE_INITIAL_VALUE;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void changeDistance() {
        ++distanceTraveled;
    }
}
