package racingcar.refactoring.domain;

import java.util.Objects;

import static racingcar.refactoring.utils.NumberGenerator.generateRandomNumber;

public class Car {

    private static final int RANDOM_THRESHOLD = 4;

    private final Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(0);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public void moveForward(int randomNumber) {
        if (movable(randomNumber)) {
            position = position.plusPosition();
        }
    }

    public void move() {
        moveForward(generateRandomNumber());
    }

    private boolean movable(int randomNumber) {
        return randomNumber >= RANDOM_THRESHOLD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
