package racingcar.domain;

public class Car {
    private static final int MOVE_VALUE = 1;

    private final Position position;

    private Car(Position position) {
        this.position = position;
    }

    public static Car from() {
        return new Car(Position.from(MOVE_VALUE));
    }

    public Car move(MovingStrategy movingStrategy) {
        if (movingStrategy.move()) {
            return new Car(position.move(MOVE_VALUE));
        }
        return this;
    }

    public Position getPosition() {
        return position;
    }
}
