package camp.nextstep.edu.racingcar.domain;

import java.util.Objects;

public class Car {
    private static final int POSITION_INITIAL_VALUE = 0;
    private static final int POSITION_MINIMUM_VALUE = 0;
    private static final Car DEFAULT = new Car(POSITION_INITIAL_VALUE);

    private final int position;

    private Car(int position) {
        if (position < POSITION_MINIMUM_VALUE) {
            throw new IllegalArgumentException("'position' must be greater than or equal to " + POSITION_MINIMUM_VALUE +
                    ". position:" + position);
        }
        this.position = position;
    }

    public static Car from(int position) {
        return new Car(position);
    }

    public static Car defaultInstance() {
        return DEFAULT;
    }

    public int getPosition() {
        return position;
    }

    public Car move(int distance) {
        return new Car(position + distance);
    }

    @Override
    public String toString() {
        return "Car{" +
                "position=" + position +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
