package racing.domain.car;

import java.util.Objects;

public class Car {

    private final Position position;

    public Car() {
        this(0);
    }

    public Car(Position position) {
        this.position = position;
    }

    public Car(int position) {
        this(new Position(position));
    }

    public Car move() {
        return new Car(position.advance());
    }

    public int position() {
        return position.value();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
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
