package racing.core.domain;

import racing.core.exception.ErrorMessage;
import racing.core.patterns.MoveStrategy;

import java.util.Objects;

public final class Car implements Comparable<Car> {

    private static final int LENGTH_LIMIT = 5;

    private final String name;
    private final int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    public Car(String name, int position) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    private void validateName(String name) {
        if (Objects.isNull(name) || name.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NULL_OR_EMPTY_VALUE.getMessage());
        }
        if (name.length() > LENGTH_LIMIT) {
            throw new IllegalArgumentException(ErrorMessage.LENGTH_OVER.getMessage());
        }
    }

    public Car move(MoveStrategy movement) {
        if (movement.canMove()) {
            return new Car(name, position + 1);
        }
        return new Car(name, position);
    }

    public boolean isSamePosition(Car car) {
        return this.position == car.position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position &&
                name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public int compareTo(Car o) {
        return o.position - this.position;
    }
}
