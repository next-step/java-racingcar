package racing.domain;

import java.util.Objects;

public class Car {

    private final Name name;
    private final Position position;

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public void move(MovableStrategy movableStrategy) {
        position.move(movableStrategy);
    }

    public boolean equalsPosition(int maxPosition) {
        return position.equalsPosition(maxPosition);
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
        return Objects.equals(name, car.name) && Objects.equals(position,
            car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
