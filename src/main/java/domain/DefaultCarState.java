package domain;

public class DefaultCarState implements CarState {
    private final int position;

    private DefaultCarState(int position) {
        this.position = position;
    }

    public static DefaultCarState create(int position) {
        return new DefaultCarState(position);
    }

    public CarState copy() {
        return DefaultCarState.create(position);
    }

    public int position() {
        return position;
    }

    public CarState move(CarDisplacement carDisplacement) {
        return create(position + carDisplacement.displacement());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DefaultCarState that = (DefaultCarState) o;
        return position == that.position;
    }

    @Override
    public String toString() {
        return String.format("{position : %d}", position);
    }
}
