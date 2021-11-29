package racing.refactor.domain;

import java.util.Objects;

public class Car {

    private static final int DEFAULT_POSITION = 0;

    private final Name name;
    private final Position position;

    public Car(String name) {
        this(name, DEFAULT_POSITION);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void move(MovingStrategy strategy) {
        if(strategy.movable()) {
            position.move();
        }
    }

    protected Position getPosition() {
        return position;
    }

    public boolean equalsPosition(int distance) {
        return this.position.equals(new Position(distance));
    }

    public boolean equalsPosition(Position position) {
        return this.position.equals(position);
    }

    protected Name getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (! (o instanceof Car)) return false;
        Car car=(Car) o;
        return name.equals(car.name) && position.equals(car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name=" + name +
                ", position=" + position +
                '}';
    }
}
