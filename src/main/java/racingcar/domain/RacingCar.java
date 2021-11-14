package racingcar.domain;

import racingcar.domain.value.CarName;
import racingcar.domain.value.Position;
import racingcar.service.util.Validation;

import java.util.Objects;

public class RacingCar {

    private final Position position;
    private final CarName carName;

    public RacingCar(String carName) {
        this(Position.create(0), CarName.create(carName));
    }

    public RacingCar(Position position, CarName carName) {

        Validation.nullCheck(position);

        this.position = position;
        this.carName = carName;
    }

    public static RacingCar create(String carName) {

        return new RacingCar(Position.create(0), CarName.create(carName));
    }

    public void decisionMove(boolean decision) {
        if(decision) {
            position.increaseLocation();
        }
    }

    public int getLocation() {

        return this.position.getLocation();
    }

    public CarName getCarName() {
        return carName;
    }

    public boolean isWinner(Position maxPosition) {
        return position.equals(maxPosition);
    }

    public Position getMaxPosition(Position maxPosition) {
        if (position.isGreaterThan(maxPosition)) {
            return position;
        }

        return maxPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar1 = (RacingCar) o;
        return Objects.equals(position, racingCar1.position);
    }

    @Override
    public int hashCode() {

        return Objects.hash(position);
    }

}
