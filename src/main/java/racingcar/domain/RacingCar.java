package racingcar.domain;

import java.util.Objects;

public class RacingCar {

    private static final String DASH = "-";
    private int position;

    public RacingCar() {
        this(0);
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
        return randomNumber >= 4;
    }

    public String movingDistance() {
        return DASH.repeat(Math.max(0, position));
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
