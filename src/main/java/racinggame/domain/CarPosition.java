package racinggame.domain;

public class CarPosition {

    private static final int MIN_POSITION = 0;
    private static final int MOVE_THRESHOLD = 4;
    private final int position;

    public CarPosition() {
        this(MIN_POSITION);
    }

    public CarPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public CarPosition move(int position) {
        if (position >= MOVE_THRESHOLD) {
            return new CarPosition(this.position + 1);
        }
        return this;
    }

    public int compareAndReturnMax(int currentMax) {
        return Math.max(currentMax, this.position);
    }

    public boolean isGreaterThanOrEqual(int targetPosition) {
        return this.position >= targetPosition;
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
        return Integer.hashCode(position);
    }

    @Override
    public String toString() {
        return String.valueOf(position);
    }
}
