package step4.racingcar;

public class RacingCar {
    private final String carName;
    private int distanceTraveled;

    public RacingCar(final String carName) {
        this.carName = carName;
        this.distanceTraveled = 0;
    }

    public String carName() {
        return carName;
    }

    public int currentDistance() {
        return distanceTraveled;
    }

    public void moveIfInRange(final int value) {
        if (isStopRange(value)) {
            return;
        }

        distanceTraveled++;
    }

    private boolean isStopRange(final int value) {
        return 0 <= value && value < 4;
    }

    @Override
    public String toString() {
        return "-".repeat(distanceTraveled);
    }
}
