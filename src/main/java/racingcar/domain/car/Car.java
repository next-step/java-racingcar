package racingcar.domain.car;

import java.util.Objects;
import racingcar.domain.MoveStrategy;

public class Car {

    private Position position;

    public Car() {
        this(0);
    }

    public Car(int position) {
        this.position = new Position(position);
    }

    public Car(Position position) {
        this.position = position;
    }

    public Car move(MoveStrategy moveStrategy) {
        if (moveStrategy.canMove()) {
            return new Car(position.move());
        }
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car)) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
