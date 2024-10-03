package racingcar.winner.domain;

import java.util.Objects;

public class Car {

    private static final int RANDOM_THRESHOLD = 4;

    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward(int randomNumber) {
        if (movable(randomNumber)) {
            position++;
        }
    }

    private boolean movable(int randomNumber) {
        return randomNumber >= RANDOM_THRESHOLD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
