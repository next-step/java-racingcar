package racingcar.domain;

import java.util.Objects;

public class RacingCar {

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
