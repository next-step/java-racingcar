package racingcar.domain;

import static racingcar.constant.Constant.DASH;
import static racingcar.constant.Constant.LEAST_MOVE_CONDITION;
import static racingcar.constant.Constant.START_POSITION;
import static racingcar.constant.Constant.ZERO;

import java.util.Objects;

public class RacingCar {
    private Position position;

    public RacingCar() {
        this(START_POSITION);
    }

    public RacingCar(long position) {
        this.position = new Position(position);
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
        return DASH.repeat(position.sizeComparison(ZERO));
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
