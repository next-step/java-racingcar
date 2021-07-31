package carracing.domain;

import java.util.Objects;

public class Car {

    private static final int MOVE_THRESHOLD = 3;

    private Position position;
    private final CarName carName;

    public Car(Position position, CarName carName) {
        this.position = position;
        this.carName = carName;
    }

    public static Car of(Position initPosition, CarName carName) {
        return new Car(initPosition, carName);
    }

    public Position getPosition() {
        return position;
    }

    public CarName getCarName() {
        return carName;
    }

    public void move(Number number) {
        if (Objects.requireNonNull(number).isOver(MOVE_THRESHOLD)) {
            position = position.next();
        }
    }
}
