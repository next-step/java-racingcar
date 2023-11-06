package racingcar.domain;

import java.util.Objects;

public class RacingCar {

    private static final String DASH = "-";
    private static final int START_POSITION = 0;
    private static final int LEAST_MOVE_CONDITION = 4;
    private static final int ZERO = 0;
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
