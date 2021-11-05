package racingcar.domain;

import java.util.Objects;

public class Car {
    private static final int MOVE_VALUE = 1;

    private Position position;

    private Car(Position position) {
        this.position = position;
    }

    public static Car from() {
        return new Car(Position.from(MOVE_VALUE));
    }

    public static Car from(int position) {
        return new Car(Position.from(position));
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.move()) {
            position = position.move(MOVE_VALUE);
        }
    }

    public int getPosition() {
        return position.getPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
