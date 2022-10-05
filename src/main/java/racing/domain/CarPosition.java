package racing.domain;

import java.util.Objects;

public class CarPosition {
    private int position;
    private final static int SPEED = 1;

    public CarPosition() {
        this.position = 1;
    }

    public CarPosition(int initPosition) {
        this.position = initPosition;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        this.position += SPEED;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarPosition that = (CarPosition) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
