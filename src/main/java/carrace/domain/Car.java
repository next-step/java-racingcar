package carrace.domain;

import carrace.moving.Moving;
import carrace.moving.RandomMoving;

public class Car {

    private final RandomMoving randomMoving = new RandomMoving();

    private final Name name;

    private Position position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }
    public void move(Moving moving) {
        this.position = this.position.add(moving.move());
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    @Override
    public String toString() {
        return "Car{" +
                "randomMoving=" + randomMoving +
                ", name='" + name + '\'' +
                ", position=" + position +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (name != null ? !name.equals(car.name) : car.name != null) return false;
        return position != null ? position.equals(car.position) : car.position == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }
}
