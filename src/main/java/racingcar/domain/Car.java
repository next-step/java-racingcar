package racingcar.domain;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private int position;
    private final String name;

    public Car() {
        this(0, "");
    }

    public Car(final int position) {
        this(position, "");
    }

    public Car(final String name) {
        this(0, name);
    }

    public Car(final int position, final String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("Car names cannot exceed 5 characters");
        }
        this.position = position;
        this.name = name;
    }

    public void move(final MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            this.position++;
        }
    }

    public boolean isEqualsPosition(final Car other) {
        return compareTo(other) == 0;
    }

    public String print() {
        return this.name + " : " + "-".repeat(this.position);
    }

    public Car copy() {
        return new Car(this.position, this.name);
    }

    public String getName() {
        return this.name;
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
        return this.position == car.position && Objects.equals(this.name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.position, this.name);
    }

    @Override
    public String toString() {
        return "Car{" +
                "position=" + position +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Car other) {
        return Integer.compare(this.position, other.position);
    }
}
