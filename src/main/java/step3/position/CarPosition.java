package step3.position;

import java.util.Objects;

public final class CarPosition implements Position {

    private static final int DISTANCE = 1;

    private final int position;

    public CarPosition(int position) {
        this.position = position;
    }

    @Override
    public Position movedPosition() {
        return new CarPosition(position + DISTANCE);
    }

    @Override
    public int position() {
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
