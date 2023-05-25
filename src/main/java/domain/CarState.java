package domain;

public class CarState {
    private final int position;

    private CarState(int position) {
        this.position = position;
    }

    public static CarState create(int position) {
        return new CarState(position);
    }

    public CarState copy() {
        return CarState.create(position);
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
        CarState that = (CarState) o;
        return position == that.position;
    }

    @Override
    public String toString() {
        return String.format("{position : %d}", position);
    }
}
