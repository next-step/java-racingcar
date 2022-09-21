package racingcar.domain;

public class Car {
    public static final int DEFAULT_MOVEMENT_DISTANCE = 1;

    private final Position position;

    public Car(int position) {
        this.position = new Position(position);
    }

    public Car(Position position) {
        this.position = position;
    }

    public Car() {
        this(0);
    }

    public int position() {
        return position.getPosition();
    }

    public Car move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            Position newPosition = position.add(new Position(DEFAULT_MOVEMENT_DISTANCE));
            return new Car(newPosition);
        }

        return this;
    }

    @Override
    public String toString() {
        return "-".repeat(position.getPosition());
    }
}
