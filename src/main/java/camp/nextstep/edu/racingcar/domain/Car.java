package camp.nextstep.edu.racingcar.domain;

import camp.nextstep.edu.util.AssertUtils;
import camp.nextstep.edu.util.StringUtils;

import java.util.Objects;

public class Car {

    private final String name;
    private final Position position;

    private Car(String name, Position position) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("'name' must not be null or empty");
        }
        AssertUtils.notNull(position, "'position' must not be null");

        this.name = name;
        this.position = position;
    }

    public static Car from(String name) {
        final Position origin = Position.origin();
        return new Car(name, origin);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position.getValue();
    }

    public Car move(int distance) {
        final Position movedPosition = position.add(distance);
        return new Car(name, movedPosition);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return name.equals(car.name) &&
                position.equals(car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
