package racingcar.domain.car;

import java.util.Objects;
import racingcar.domain.MoveStrategy;

public class Car {

    private final Name name;
    private final Position position;

    private Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public static Car createWithName(String name) {
        return createWithNameAndPosition(name, 0);
    }

    public static Car createWithNameAndPosition(String name, int position) {
        return new Car(new Name(name), new Position(position));
    }

    public Car move(MoveStrategy moveStrategy) {
        if (moveStrategy.canMove()) {
            return new Car(name, position.move());
        }
        return this;
    }

    public int getIntPosition() {
        return position.getPosition();
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
        return Objects.equals(name, car.name) && Objects
                .equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
