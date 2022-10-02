package racingcarGame.model;

import java.util.Objects;

public class Car {
    private static final int RANDOM_BASE_VALUE = 4;

    private int position;
    private String name;

    public Car(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public void move(int chosenNumber) {
        if (isMovable(chosenNumber)) {
            this.position += 1;
        }
    }

    boolean isMovable(int num) {
        return num >= RANDOM_BASE_VALUE;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }
}
