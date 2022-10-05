package racing.domain;

import java.util.Objects;

public class Car {

    private static final int NAME_LENGTH = 5;
    private static final String LENGTH_ERROR_TEXT = "이름은 5자를 초과할 수 없습니다.";

    private String name;
    private int distance;

    public Car(String name, int distance) {
        this.name = validateName(name);
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void move(MovableStrategy movableStrategy) {
        distance += movableStrategy.randomMovable();
    }

    private String validateName(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException(LENGTH_ERROR_TEXT);
        }

        return name;
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
        return distance == car.distance && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance);
    }
}
