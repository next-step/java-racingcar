package carrace;

import java.util.Objects;

public class Car {
    private static final int START_POSITION = 0;
    private static final int ZERO_INDEX = 0;
    private static final int LIMIT_NAME_LENGTH = 5;
    private static final String DEFAULT_DRIVER_NAME = "CAR_";

    private final int index;
    private final String name;
    private int position;

    public Car(int index, String name) {
        this(name, START_POSITION, index);
    }

    Car() {
        this(DEFAULT_DRIVER_NAME, START_POSITION, ZERO_INDEX);
    }

    Car(String name) {
        this(name, START_POSITION, ZERO_INDEX);
    }

    Car(int position) {
        this(DEFAULT_DRIVER_NAME, position, ZERO_INDEX);
    }

    Car(String name, int position, int index) {
        name = getNameOrDefault(name, index);
        validateName(name);
        this.index = index;
        this.name = name;
        this.position = position;
    }

    private String getNameOrDefault(String name, int index) {
        name = name.trim();
        if (name == null || name.isEmpty()) {
            return DEFAULT_DRIVER_NAME + index;
        }
        return name;
    }

    private void validateName(String name) {
        if (name.length() > LIMIT_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }

    public void move(boolean movable) {
        if (movable) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public Car copy() {
        return new Car(name, position, index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (position != car.position) return false;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + position;
        return result;
    }
}
