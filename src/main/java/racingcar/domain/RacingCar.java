package racingcar.domain;

import static racingcar.constant.Constant.DASH;
import static racingcar.constant.Constant.LEAST_MOVE_CONDITION;
import static racingcar.constant.Constant.START_POSITION;
import static racingcar.constant.Constant.ZERO;

import java.util.Objects;

public class RacingCar {
    private int position;

    public RacingCar() {
        this(START_POSITION);
    }

    public RacingCar(int position) {
        this.position = position;
    }

    public void move(int randomNumber) {
        if (movable(randomNumber)) {
            this.position++;
        }
    }

    private boolean movable(int randomNumber) {
        return randomNumber >= LEAST_MOVE_CONDITION;
    }

    public String movingDistance() {
        return DASH.repeat(Math.max(ZERO, position));
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
        return position == racingCar.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
