package racingcar.domain;

public class Car {
    private final int position;

    public Car(int position) {
        this.position = position;
    }

    public Car() {
        this(0);
    }

    public int position() {
        return position;
    }

    public Car move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            return new Car(position + 1);
        }

        return this;
    }

    @Override
    public String toString() {
        return "-".repeat(position);
    }
}
