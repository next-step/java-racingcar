package model;

import java.util.Objects;

public class CarPosition implements Comparable<CarPosition> {

    private final int position;

    public CarPosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("position must be positive");
        }
        this.position = position;
    }

    public CarPosition move() {
        return new CarPosition(this.position + 1);
    }

    public int getPosition() {
        return position;
    }


    @Override
    public int compareTo(CarPosition target) {
        return Integer.compare(this.position, target.position);
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
