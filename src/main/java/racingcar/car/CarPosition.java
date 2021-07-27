package racingcar.car;

import java.util.Objects;

public class CarPosition {

    private static final int INITIAL_POSITION = 0;

    private int position;

    public CarPosition() {
        this(INITIAL_POSITION);
    }

    public CarPosition(int position) {
        this.position = position;
    }

    public void increase() {
        position++;
    }

    public CarPosition max(CarPosition position) {
        if (this.position > position.getPosition()) {
            return this;
        }
        return position;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPosition that = (CarPosition) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
