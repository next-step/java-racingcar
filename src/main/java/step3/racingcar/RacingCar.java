package step3.racingcar;

public class RacingCar {
    private int distanceTraveled;

    public RacingCar() {
        this.distanceTraveled = 0;
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
