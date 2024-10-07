package racingcar.domain;

import java.util.Objects;

public class Car {
    private int position;
    private final String name;

    public Car(String name) {
        this(0, name);
    }

    public Car(int position, String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("Car names cannot exceed 5 characters");
        }
        this.position = position;
        this.name = name;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
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
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }
}
