package step3.models;

import java.util.Objects;
import step3.exception.ExceedLengthException;
import step3.exception.NullOrEmptyException;

public class Car implements Comparable<Car> {
    private static final int MIN_NUM_TO_MOVE = 4;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private final int position;

    public static Car init(String name) {
        if (name == null || name.isBlank()) {
            throw new NullOrEmptyException();
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new ExceedLengthException(MAX_NAME_LENGTH);
        }

        return new Car(name, 0);
    }

    Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public Car move(int number) {
        if (number >= MIN_NUM_TO_MOVE) {
            return new Car(this.name, this.position + 1);
        }

        return this;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Car o) {
        return this.getPosition() < o.getPosition() ? -1 : 1;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.position);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Car car = (Car) obj;
        return Objects.equals(this.name, car.name) &&
                Objects.equals(this.position, car.position);
    }
}
