package carrace.domain;

import java.util.Objects;

public class Car {
    private static final int START_POSITION = 0;
    private static final int LIMIT_NAME_LENGTH = 5;
    private final String name;
    private int position;

    Car(String name) {
        this(name, START_POSITION);
    }

    Car(String name, int position) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("이름은 null이나 빈 문자열이 될 수 없습니다.");
        }
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
        return new Car(name, position);
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
