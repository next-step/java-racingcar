package racingcar.domain;

import java.util.Objects;

public class Car {
    private static final int MOVE_CRITERIA = 4;
    private static final int MOVE_VALUE = 1;

    private Position position;

    private Car(Position position) {
        this.position = position;
    }

    public static Car from() {
        return new Car(Position.init());
    }

    public static Car from(int position) {
        return new Car(Position.from(position));
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.generateNumber() > MOVE_CRITERIA) {
            position.move(MOVE_VALUE);
        }
    }

    public int currentPosition() {
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
