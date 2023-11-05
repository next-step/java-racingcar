package step3.racingcar;

public class RacingCar {
    private int distanceTraveled;

    private RacingCar() {
    }

    public static RacingCar build() {
        return new RacingCar();
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
}
