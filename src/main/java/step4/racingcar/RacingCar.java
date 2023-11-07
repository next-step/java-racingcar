package step4.racingcar;

public class RacingCar {
    private final String carName;
    private int distanceTraveled;

    public RacingCar(final String carName) {
        if (isCarNameLengthOver(carName)) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }

        this.carName = carName;
        this.distanceTraveled = 0;
    }

    private boolean isCarNameLengthOver(final String carName) {
        return carName.length() > 5;
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
        final String result = "-".repeat(distanceTraveled);
        
        return carName + " : " + result;
    }
}
