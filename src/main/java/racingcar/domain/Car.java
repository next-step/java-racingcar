package racingcar.domain;

public class Car {
    public static final String POSITION_EXCEPTION_MESSAGE = "위치는 0 이상이어야 합니다.";

    private final int position;

    public Car(int position) {
        validate(position);

        this.position = position;
    }

    private void validate(int position) {
        if (isNegative(position)) {
            throw new IllegalArgumentException(POSITION_EXCEPTION_MESSAGE);
        }
    }

    private boolean isNegative(int position) {
        return position < 0;
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
