package step3.domain;

public class CarRacingResult {
    private final String carName;
    private final int carPosition;

    public CarRacingResult(final String carName, final int carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public String getCarName() {
        return carName;
    }

    public int getCarPosition() {
        return carPosition;
    }
}
