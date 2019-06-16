package camp.nextstep.edu.racingcar.domain;

import camp.nextstep.edu.util.StringUtils;

import java.util.Objects;

public class Car {
    private static final int POSITION_INITIAL_VALUE = 0;
    private static final int POSITION_MINIMUM_VALUE = 0;

    private final String name;
    private final int position;

    private Car(String name, int position) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("'name' must not be null or empty");
        }
        if (position < POSITION_MINIMUM_VALUE) {
            throw new IllegalArgumentException("'position' must be greater than or equal to " + POSITION_MINIMUM_VALUE +
                    ". position:" + position);
        }
        this.name = name;
        this.position = position;
    }

    public static Car from(String name) {
        return new Car(name, POSITION_INITIAL_VALUE);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public Car move(int distance) {
        return new Car(name, position + distance);
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
        return position == car.position &&
                name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
