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

    public void move(final int conditionValue) {
        if (isStopCondition(conditionValue)) {
            return;
        }
    }

    private boolean isStopCondition(final int conditionValue) {
        return 0 <= conditionValue && conditionValue < 4;
    }
}
