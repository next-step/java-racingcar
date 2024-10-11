package carracing.domain.carracing;

import java.util.Objects;

public class Car {
    private final Name name;
    private Position position;

    public Car(String carName) {
        this(new Name(carName), new Position());
    }

    public Car(String carName, int position) {
        this(new Name(carName), new Position(position));
    }

    private Car(Name carName, Position position) {
        this.name = carName;
        this.position = position;
    }

    public void move() {
        this.position = this.position.increase();
    }

    public int compareMax(int max) {
        return this.position.compareMax(max);
    }

    public boolean isSamePosition(int position) {
        return this.position.isSame(position);
    }

    public Position getPosition() {
        return this.position;
    }

    public String getNameString() {
        return this.name.getValue();
    }

    public Car deepCopy() {
        return new Car(this.name, this.position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return name.equals(car.name) && position.equals(car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
