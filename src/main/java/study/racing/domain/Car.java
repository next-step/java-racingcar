package study.racing.domain;

import java.util.Objects;

public class Car {
    private static final int DEFAULT_POSITION = 0;
    private static final int MOVE_CONDITION = 4;
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int position;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.position = DEFAULT_POSITION;
    }

    private void validate(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 5글자를 초과할 수 없습니다.");
        }
    }

    public void move(int randonValue) {
        if (randonValue >= MOVE_CONDITION) {
            this.position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "Car{name= " + name + ", position=" + position + "}";
    }
}
