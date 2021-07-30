package carracing.domain;

import java.util.Objects;

public class Car {

    private static final int MOVE_THRESHOLD = 3;

    private Position position;

    private Car(Position position) {
        this.position = Objects.requireNonNull(position);
    }

    public static Car of(int initPosition) {
        return new Car(Position.of(initPosition));
    }

    public Position getPosition() {
        return position;
    }

    public void move(Number number) {
        if (Objects.requireNonNull(number).isOver(MOVE_THRESHOLD)) {
            position = position.next();
        }
    }
}
