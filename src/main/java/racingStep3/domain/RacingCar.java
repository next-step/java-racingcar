package racingStep3.domain;

import racingStep3.service.Validation;

import java.util.Objects;

public class RacingCar {

    private final Position position;
    private static final Integer MIN_GO_VALUE = 4;

    public RacingCar(Position position) {

        Validation.nullCheck(position);

        this.position = position;
    }

    public static RacingCar create() {
        return new RacingCar(Position.create(0));
    }

    public void moveOrNot(int forward) {
        if(forward >= MIN_GO_VALUE) {
            position.increaseLocation();
        }
    }

    public int getLocation() {
        return this.position.getLocation();
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
