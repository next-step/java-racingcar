package racinggame.domain;

import java.util.Objects;

public class RacingCar {

    private static final int MINIMUM_FORWARD_VALUE = 4;
    private static final int INIT_POSITION = 0;

    private String carName;
    private int carPosition;

    public RacingCar(String carName) {
        this(carName, INIT_POSITION);
    }

    public RacingCar(String carName, int position) {
        Validator.validateNameLength(carName);
        this.carName = carName;
        this.carPosition = position;
    }

    public boolean canForward(int randomValue) {
        return randomValue >= MINIMUM_FORWARD_VALUE;
    }

    public void forward() {
        this.carPosition += 1;
    }

    public int getPosition() {
        return this.carPosition;
    }

    public String getCarName() {
        return this.carName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RacingCar racingCar = (RacingCar) o;
        return carPosition == racingCar.carPosition && Objects.equals(carName,
                racingCar.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, carPosition);
    }

    public boolean isMatchePosition(int maxPosition) {
        return this.carPosition == maxPosition;
    }
}
