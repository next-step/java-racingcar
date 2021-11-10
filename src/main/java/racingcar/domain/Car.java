package racingcar.domain;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private final Name name;
    private Position position;

    public Car of() {
        return new Car(name, position.of());
    }

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this(new Name(name), new Position(position));
    }

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public void move(MovePredicate movePredicate) {
        if (movePredicate.test()) {
            this.position = position.nextPosition();
        }
    }

    public boolean samePosition(Car other) {
        return this.position.equals(other.position);
    }

    public String statusWithNameAndPosition() {
        StringBuilder sb = new StringBuilder();
        sb = sb.append(name.value()).append(" : ");
        for (int i = 0; i < position.value(); i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public String statusWithName() {
        return name.value();
    }

    @Override
    public int compareTo(Car other) {
        return this.position.compareTo(other.position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
