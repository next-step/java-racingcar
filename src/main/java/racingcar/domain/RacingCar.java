package racingcar.domain;

import static racingcar.constant.Constant.DASH;
import static racingcar.constant.Constant.DEFAULT_POSITION;
import static racingcar.constant.Constant.LEAST_MOVE_CONDITION;

import java.util.Objects;

public class RacingCar {
    public static final String CAR_NAME_LENGTH_EXCEPTION = "자동차 이름은 1자에서 5자 사이여야 합니다. 이름이 공백이거나 비어있어도 안됩니다.";
    private final String name;
    private Position position;

    public RacingCar(String carName, long position) {
        validateCarName(carName);
        this.name = carName;
        this.position = new Position(position);
    }

    private void validateCarName(String carName) {
        if (isOutOfLength(carName)) {
            throw new IllegalStateException(CAR_NAME_LENGTH_EXCEPTION);
        }
    }

    private boolean isOutOfLength(String carName) {
        return carName.isEmpty() || carName.isBlank() || carName.length() > 5;
    }

    public RacingCar(String carName) {
        this(carName, 0);
    }

    public void move(int randomNumber) {
        if (movable(randomNumber)) {
            this.position = position.move();
        }
    }

    private boolean movable(int randomNumber) {
        return randomNumber >= LEAST_MOVE_CONDITION;
    }

    public String movingDistance() {
        return DASH.repeat(position.sizeComparison(DEFAULT_POSITION));
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
        return Objects.equals(position, racingCar.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
