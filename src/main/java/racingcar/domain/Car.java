package racingcar.domain;

public class Car {
    public static final String POSITION_EXCEPTION_MESSAGE = "위치는 0 이상이어야 합니다.";
    public static final int DEFAULT_MOVEMENT_DISTANCE = 1;

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
            return new Car(position + DEFAULT_MOVEMENT_DISTANCE);
        }

        return this;
    }

    @Override
    public String toString() {
        return "-".repeat(position);
    }
}
