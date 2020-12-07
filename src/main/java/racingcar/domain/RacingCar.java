package racingcar.domain;

import java.util.Objects;

public class RacingCar {

    private int carPosition;

    public RacingCar() {
    }

    public RacingCar(int carPosition) {
        this.carPosition = carPosition;
    }

    public RacingCar run(MoveRule racingRule) {
        if(racingRule.checkMovement()) {
            carPosition++;
        }
        return new RacingCar(this.carPosition);
    }

    public int getCarPosition() {
        return carPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return carPosition == racingCar.carPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(carPosition);
    }
}
